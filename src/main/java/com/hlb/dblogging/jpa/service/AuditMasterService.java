package com.hlb.dblogging.jpa.service;

import java.util.List;

import com.hlb.dblogging.jpa.model.AuditMaster;
import com.hlb.dblogging.jpa.model.SearchBean;

public interface AuditMasterService {
	void create(AuditMaster auditMaster);
	List<AuditMaster> getListOfMessages();
	List<AuditMaster> getSearchResultList(SearchBean searchCriteria);
	
}
