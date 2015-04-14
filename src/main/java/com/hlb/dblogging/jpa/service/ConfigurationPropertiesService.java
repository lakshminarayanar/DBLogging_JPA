package com.hlb.dblogging.jpa.service;

import com.hlb.dblogging.jpa.model.ConfigurationProperties;

public interface ConfigurationPropertiesService {

	String getLogLevelForMessageSaving();
	String updateLoglevl(String logLevel);
	String updateNewXSLTFile(String newXSLT);
	ConfigurationProperties getApplicationConfiguration();
}
