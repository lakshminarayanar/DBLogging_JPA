package com.hlb.dblogging.jpa.service;

import java.util.Date;
import java.util.List;

import com.hlb.dblogging.jpa.model.AuditMaster;
import com.hlb.dblogging.jpa.model.SearchBean;

public interface AuditMasterService {
	long create(AuditMaster auditMaster);
	List<AuditMaster> getListOfMessages();
	List<AuditMaster> getListOfMessagesByTime(Date date);
	List<AuditMaster> getSearchResultList(SearchBean searchCriteria);
	List<AuditMaster> getResultByUniqueProcessId(String uniqueProcessId);
	
}
