package com.hlb.dblogging.jpa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlb.dblogging.jpa.model.AuditMaster;
import com.hlb.dblogging.jpa.repository.AuditMasterRepository;
import com.hlb.dblogging.log.utility.ApplLogger;

@Service
public class AuditMasterServiceImpl implements AuditMasterService{

	@Resource
	AuditMasterRepository aMasterRepository;

	@Transactional(rollbackFor = { Exception.class })
	public void create(AuditMaster auditMaster) {
		try {
			AuditMaster auditMasterToBeCreated = auditMaster;
			aMasterRepository.save(auditMasterToBeCreated);
			ApplLogger.getLogger().info("AuditMaster is saved in Database...!!! : "+auditMasterToBeCreated.getUniqueProcessID());

		} catch (Exception e) {
			ApplLogger.getLogger().error("Error caught while saving the AuditMaster instance to Database",e);
			if(aMasterRepository==null)
				ApplLogger.getLogger().info("Repository is not instantiated by Spring container...");
		}

	}
}
