package com.hlb.dblogging.jpa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hlb.dblogging.jpa.model.AuditMaster;

public interface AuditMasterRepository extends CrudRepository<AuditMaster, Integer>{

	@Query("select e from AuditMaster e where MessageFormat = ?")
	List<AuditMaster> findByMessageFormat(String messageFormat);
	
}

	



