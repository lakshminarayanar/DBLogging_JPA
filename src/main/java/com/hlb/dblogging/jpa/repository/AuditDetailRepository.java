package com.hlb.dblogging.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hlb.dblogging.jpa.model.AuditDetail;


public interface AuditDetailRepository extends CrudRepository<AuditDetail, Serializable> {

	@Query("select e.content from AuditDetail e where UniqueProcessID = :uniqueProcessID")
	String findMessageContentByUniqueProcessID(@Param("uniqueProcessID") String uniqueProcessID);
	
}
