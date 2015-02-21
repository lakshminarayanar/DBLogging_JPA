package com.hlb.dblogging.jpa.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.hlb.dblogging.jpa.model.AuditDetail;


public interface AuditDetailRepository extends CrudRepository<AuditDetail, Serializable> {

	 
	
}
