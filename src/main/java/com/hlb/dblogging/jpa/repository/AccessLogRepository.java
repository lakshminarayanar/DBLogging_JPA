package com.hlb.dblogging.jpa.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hlb.dblogging.jpa.model.AccessLog;


public interface AccessLogRepository extends CrudRepository<AccessLog, Integer>  {
	
	
	@Query("select al from AccessLog al where isDeleted = 0")
	 List<AccessLog> findAll();
	
}
