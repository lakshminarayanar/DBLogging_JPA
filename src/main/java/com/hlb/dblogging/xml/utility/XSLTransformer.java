package com.hlb.dblogging.xml.utility;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.hlb.dblogging.jpa.model.XSLT;
import com.hlb.dblogging.log.utility.ApplLogger;

public class XSLTransformer {
	
	public static String defaultSaveXslStream;
	public static String defaultViewXslStream;
	public static String logLevel;
	public static String retryPath;
	public static Boolean isViewEnabled;
	public static Boolean isSaveEnabled;
	public static Map<String,String> xsltMap = new HashMap<>();
	public static String ldapUsername;
	public static String ldapPassword;
	public static String ldapUrl;
	public static String ldapDomain;
	public static String ldapSearchFilter;
	public static String rc4Key;
	
	/*public XSLTransformer() {
		try{
		// defaultSaveXslStream = XSLTransformer.class.getResourceAsStream("/xml-transformer.xsl");
			defaultSaveXslStream = IOUtils.toString(XSLTransformer.class.getResourceAsStream("/xml-transformer.xsl"), "UTF-8");
		if(defaultSaveXslStream!=null)
			ApplLogger.getLogger().info("XSL file is read successfully!!!");
		else
			ApplLogger.getLogger().info("XSL file is not found!!!");
		}catch(Exception e){
			ApplLogger.getLogger().error("Error caught : ", e);
		}
		
	}*/

}
