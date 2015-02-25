package com.hlb.dblogging.jpa.service;

import java.util.List;

import com.hlb.dblogging.jpa.model.AuditMaster;

public interface AuditMasterService {
	void create(AuditMaster auditMaster);
	List<AuditMaster> getListOfMessages();
}
