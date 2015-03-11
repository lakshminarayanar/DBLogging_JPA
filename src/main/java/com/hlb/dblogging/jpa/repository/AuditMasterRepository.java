package com.hlb.dblogging.jpa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hlb.dblogging.jpa.model.AuditMaster;

public interface AuditMasterRepository extends PagingAndSortingRepository<AuditMaster,Integer>,JpaRepository<AuditMaster,Integer>,QueryDslPredicateExecutor<AuditMaster>{

	@Query("select e from AuditMaster e where MessageFormat = ?")
	List<AuditMaster> findByMessageFormat(String messageFormat);
	
	@Query("select e from AuditMaster e")
	List<AuditMaster> findAllMessages();
	
	List<AuditMaster> findTop10ByLogInterfaceOrderByTransDateTimeDesc(String logInterface);
}

	



