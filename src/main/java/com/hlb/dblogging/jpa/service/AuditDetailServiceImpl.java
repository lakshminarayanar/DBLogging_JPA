package com.hlb.dblogging.jpa.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlb.dblogging.jpa.model.AuditDetail;
import com.hlb.dblogging.jpa.repository.AuditDetailRepository;
import com.hlb.dblogging.log.utility.ApplLogger;
import com.hlb.dblogging.xml.utility.EbcdicToAsciiConvertUtility;
import com.hlb.dblogging.xml.utility.XSLTransformer;

@Service
public class AuditDetailServiceImpl implements AuditDetailService{

	@Resource
	AuditDetailRepository aDetailRepository;
	
	@Transactional(rollbackFor ={Exception.class})
	public void create(AuditDetail adetail) {
		try{ 
			AuditDetail auditDetailToBeCreated = adetail;
			aDetailRepository.save(auditDetailToBeCreated);
			ApplLogger.getLogger().info("AuditDetail is saved in Database...!!! :"+auditDetailToBeCreated.getUniqueProcessID());
		} catch (Exception e) {
			ApplLogger.getLogger().error("Error caught while saving the AuditDetail instance to Database",e);
			if(aDetailRepository==null)
				ApplLogger.getLogger().info("Repository is not instantiated by Spring container...");
			throw new RuntimeException("Couldn't save AuditDetail data presently..");
	
		}
	}

	@Override
	public String getMessageContentFormatted(String messageFormat,String auditMasterId,String transType) {
			String content =	aDetailRepository.findMessageContentByAuditDetailID(Long.parseLong(auditMasterId));
		 if("XML".equalsIgnoreCase(messageFormat)){
	        	// Fetch the Content from AuditDetail table with uniqueprocessId and check conditions to apply XSLT while viewing
			 if(XSLTransformer.isViewEnabled){
				 // Global XSLT is enabled, so should apply masking on viewing
				 try{
					 ByteArrayOutputStream outputXML = new ByteArrayOutputStream();
					 Source xslt = null;
					 if(XSLTransformer.xsltMap.get(transType)!=null)
						 xslt = new StreamSource(new ByteArrayInputStream(XSLTransformer.xsltMap.get(transType).getBytes(StandardCharsets.UTF_8)));
					 else
						 xslt = new StreamSource(new ByteArrayInputStream(XSLTransformer.xsltMap.get("ALL").getBytes(StandardCharsets.UTF_8)));
					TransformerFactory factory = TransformerFactory.newInstance();
					Source xmlInput = new StreamSource(new ByteArrayInputStream(content.getBytes()));
					Transformer transformer = factory.newTransformer(xslt);
					transformer.transform(xmlInput,	new StreamResult(outputXML));
					content =  new String(outputXML.toByteArray(),StandardCharsets.UTF_8);
				 }catch(Exception e){
					 e.printStackTrace();
					 return "Can't display content now, Error caught while applying XSLT on the message";
				 }
			 }
			 	return prettyFormat(content);
	        }else{
	        	// Fetch the Content from AuditDetail table with uniqueprocessId convert to ASCII Format and display in dialog
	        	content =	hexToCharacter(content);
	        	return	new EbcdicToAsciiConvertUtility().convert(content);
	        }
	}
	
	@Override
	public String getMessageContentInRawFormat(String messageFormat,String uniqueProcessID) {
			return 	aDetailRepository.findMessageContentByAuditDetailID(Long.parseLong(uniqueProcessID));
	}
	
	
	/*public String format(String unformattedXml) {
        try {
            final Document document = parseXmlFile(unformattedXml);

            OutputFormat format = new OutputFormat(document);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);

            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
	
	
	public  String prettyFormat(String input) {
	    try {
	        Source xmlInput = new StreamSource(new StringReader(input));
	        StringWriter stringWriter = new StringWriter();
	        StreamResult xmlOutput = new StreamResult(stringWriter);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        transformerFactory.setAttribute("indent-number", 2);
	        Transformer transformer = transformerFactory.newTransformer(); 
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.transform(xmlInput, xmlOutput);
	        return xmlOutput.getWriter().toString();
	    } catch (Exception e) {
	       // throw new RuntimeException(e); // simple exception handling, please review it
	    	return input;
	    }
	}
	
	private static String hexToCharacter(String hexValue)
	   {
	      StringBuilder output = new StringBuilder("");
	      for (int i = 0; i < hexValue.length(); i += 2)
	      {
	         String str = hexValue.substring(i, i + 2);
	         output.append((char) Integer.parseInt(str, 16));
	      }
	      return output.toString();
	   }
		
}

