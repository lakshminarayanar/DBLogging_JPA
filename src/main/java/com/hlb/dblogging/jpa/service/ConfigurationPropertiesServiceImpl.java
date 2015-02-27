package com.hlb.dblogging.jpa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hlb.dblogging.jpa.model.ConfigurationProperties;
import com.hlb.dblogging.jpa.repository.ConfigurationPropertiesRepository;

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

}
