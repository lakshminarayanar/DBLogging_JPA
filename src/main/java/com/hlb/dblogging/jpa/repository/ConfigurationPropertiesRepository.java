package com.hlb.dblogging.jpa.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hlb.dblogging.jpa.model.ConfigurationProperties;

public interface ConfigurationPropertiesRepository extends CrudRepository<ConfigurationProperties, Integer>{

	@Query("select logLevel from ConfigurationProperties")
	String findLogLevelConfiguredInDatabase();
	
	@Query("select e from ConfigurationProperties e")
	ConfigurationProperties findConfigurationPropertiesOfApplication();
	
}

	



