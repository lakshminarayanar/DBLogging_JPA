package com.hlb.dblogging.user.accesslog.logging;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlb.dblogging.jpa.model.AccessLog;
import com.hlb.dblogging.jpa.repository.AccessLogRepository;



@Service
public class AccessLogServiceImpl implements AccessLogService {


	
    @Autowired
	private AccessLogRepository accessLogRepository;
	

	@Override
	public List<AccessLog> findAll() {
		// TODO Auto-generated method stub
		List<AccessLog> resultList = (List<AccessLog>) accessLogRepository.findAll();
		return resultList;
	}



/*	@Override
	
	public AccessLog create(AccessLog accessLog) {
		AccessLog log = accessLog;
		return accessLogRepository.save(log);
	}*/
		
	
	public void log(AccessLogActivity accessLogActivity, AccessLogLevel accessLogLevel,
			int actorUserId, String actorUserName, String description) {
	
		
			
			{
				AccessLog accessLog = new AccessLog();
				
				
				
				Date currentDate = new Date();
				
				accessLog.setActionDate(currentDate);
				accessLog.setActivity(accessLogActivity.getActivity());
				accessLog.setLevel(accessLogLevel.getLevel());
				accessLog.setDescription(description);
				accessLog.setActorUserId(actorUserId);
				accessLog.setActorUsername(actorUserName);
				accessLog.setDeleted(false);
				
				accessLogRepository.save(accessLog);
			
		}
	}

}
	



