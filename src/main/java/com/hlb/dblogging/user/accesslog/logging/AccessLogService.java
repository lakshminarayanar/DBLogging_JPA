package com.hlb.dblogging.user.accesslog.logging;

import java.util.List;

import com.hlb.dblogging.jpa.model.AccessLog;


public interface AccessLogService {
	
		
		List<AccessLog> findAll();

		//AccessLog create(AccessLog accessLog);
		public void log(AccessLogActivity accessLogActivity, AccessLogLevel accessLogLevel,
				int actorUserId, String actorUserName, String description); 
	 
}
