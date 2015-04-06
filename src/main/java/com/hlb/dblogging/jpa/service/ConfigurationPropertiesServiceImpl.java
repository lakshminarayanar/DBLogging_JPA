package com.hlb.dblogging.jpa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hlb.dblogging.jpa.model.ConfigurationProperties;
import com.hlb.dblogging.jpa.repository.ConfigurationPropertiesRepository;
import com.hlb.dblogging.log.utility.ApplLogger;

@Service
public class ConfigurationPropertiesServiceImpl implements	ConfigurationPropertiesService {

	@Resource
	ConfigurationPropertiesRepository configurationRepo;
	
	@Override
	public String getLogLevelForMessageSaving() {
		return configurationRepo.findLogLevelConfiguredInDatabase();
	}

	@Override
	public ConfigurationProperties getApplicationConfiguration() {
		return configurationRepo.findConfigurationPropertiesOfApplication();
	}
	
	@Override
	public String updateLoglevl(String loglevel) {
		ConfigurationProperties configpropToBeUpdated = configurationRepo.findConfigurationPropertiesOfApplication();
		if(configpropToBeUpdated != null){
			configpropToBeUpdated.setLogLevel(loglevel);
			configurationRepo.save(configpropToBeUpdated);
			ApplLogger.getLogger().info("Loglevel updated succesfully to : "+loglevel);
		}
		return null;
	}


}
