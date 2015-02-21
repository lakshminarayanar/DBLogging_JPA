package com.hlb.dblogging.xml.utility;

import org.apache.commons.io.IOUtils;

import com.hlb.dblogging.log.utility.ApplLogger;

public class XSLTransformer {
	
	public static String xslTranformerStream;
	
	public XSLTransformer() {
		try{
		// xslTranformerStream = XSLTransformer.class.getResourceAsStream("/xml-transformer.xsl");
		xslTranformerStream = IOUtils.toString(XSLTransformer.class.getResourceAsStream("/xml-transformer.xsl"), "UTF-8");
		if(xslTranformerStream!=null)
			ApplLogger.getLogger().info("XSL file is read successfully!!!");
		else
			ApplLogger.getLogger().info("XSL file is not found!!!");
		}catch(Exception e){
			ApplLogger.getLogger().error("Error caught : ", e);
		}
		
	}

}
