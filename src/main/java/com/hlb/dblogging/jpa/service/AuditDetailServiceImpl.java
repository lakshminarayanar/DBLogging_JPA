package com.hlb.dblogging.jpa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlb.dblogging.jpa.model.AuditDetail;
import com.hlb.dblogging.jpa.repository.AuditDetailRepository;
import com.hlb.dblogging.log.utility.ApplLogger;

@Service
public class AuditDetailServiceImpl implements AuditDetailService{

	@Resource
	AuditDetailRepository aDetailRepository;
	
	@Transactional(rollbackFor ={Exception.class})
	public void create(AuditDetail adetail) {
		try{ 
			AuditDetail auditDetailToBeCreated = adetail;
			aDetailRepository.save(auditDetailToBeCreated);
			ApplLogger.getLogger().info("AuditDetail is saved in Database...!!! :"+auditDetailToBeCreated.getUniqueProcessID());
		} catch (Exception e) {
			ApplLogger.getLogger().error("Error caught while saving the AuditDetail instance to Database",e);
			if(aDetailRepository==null)
				ApplLogger.getLogger().info("Repository is not instantiated by Spring container...");
	
		}
	}
}

