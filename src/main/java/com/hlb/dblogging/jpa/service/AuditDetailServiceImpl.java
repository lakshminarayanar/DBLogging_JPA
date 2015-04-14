package com.hlb.dblogging.jpa.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.hlb.dblogging.jpa.model.AuditDetail;
import com.hlb.dblogging.jpa.repository.AuditDetailRepository;
import com.hlb.dblogging.log.utility.ApplLogger;
import com.hlb.dblogging.xml.utility.EbcdicToAsciiConvertUtility;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

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
	
		}
	}

	@Override
	public String getMessageContentFormatted(String messageFormat,String uniqueProcessID) {
			String content =	aDetailRepository.findMessageContentByUniqueProcessID(uniqueProcessID);
		 if("XML".equalsIgnoreCase(messageFormat)){
	        	// Fetch the Content from AuditDetail table with uniqueprocessId and display in dialog
			 	return format(content);
	        }else{
	        	// Fetch the Content from AuditDetail table with uniqueprocessId convert to ASCII Format and display in dialog
	        	content =	hexToCharacter(content);
	        	return	new EbcdicToAsciiConvertUtility().convert(content);
	        }
	}
	
	
	@SuppressWarnings("restriction")
	public String format(String unformattedXml) {
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
    }
	
	private Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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

