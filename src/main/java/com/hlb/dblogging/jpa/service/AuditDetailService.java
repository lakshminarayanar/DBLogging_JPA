package com.hlb.dblogging.jpa.service;

import com.hlb.dblogging.jpa.model.AuditDetail;

public interface AuditDetailService {
	void create(AuditDetail auditDetail);
	String getMessageContentFormatted(String messageFormat,String uniqueProcessID);
	
}
