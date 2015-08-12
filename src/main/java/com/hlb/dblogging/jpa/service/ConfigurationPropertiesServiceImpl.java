package com.hlb.dblogging.jpa.service;

import java.util.Date;

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
	
	@Override
	public String  updateNewXSLTFile(String newXSLT){
		try{
		ConfigurationProperties configpropToBeUpdated = configurationRepo.findConfigurationPropertiesOfApplication();
		if(configpropToBeUpdated != null){
			configpropToBeUpdated.setViewXslTransformer(newXSLT);
			configurationRepo.save(configpropToBeUpdated);
			ApplLogger.getLogger().info("New XSLT updated succesfully on :"+new Date());
		}
		}catch(Exception e){
			ApplLogger.getLogger().error("Error caught while updating new XSLT : ",e);
			throw new RuntimeException("Can't update XSLT now");
		}
		return null;
	}
	
	@Override
	public Boolean  updateXSLTSettings(Boolean xsltView, Boolean xsltSave){
		try{
		ConfigurationProperties configpropToBeUpdated = configurationRepo.findConfigurationPropertiesOfApplication();
		if(configpropToBeUpdated != null){
			configpropToBeUpdated.setViewEnabled(xsltView);
			configpropToBeUpdated.setSaveEnabled(xsltSave);
			configurationRepo.save(configpropToBeUpdated);
			ApplLogger.getLogger().info("Global updating  XSLT Settings done"+new Date());
			return Boolean.TRUE;
		}
		}catch(Exception e){
			ApplLogger.getLogger().error("Error caught while updating  XSLT Settings ",e);
		}
		return Boolean.FALSE;
	}

	
	

	}
