package com.hlb.dblogging.security.users.service;

import java.util.List;
import java.util.Set;

import com.hlb.dblogging.jpa.model.AccessRights;

public interface AccessRightsService {

	
	 AccessRights create(AccessRights accessRights);
	 AccessRights delete(int id);
	 List<AccessRights> findAll();
	 AccessRights update(AccessRights accessRights);
	 AccessRights findById(int id);	
	 Set<AccessRights> findAllInSet();
	 List<AccessRights> findAccessRightsByAccessRight(String accessRight);
	 AccessRights findAccessRights(String accessRight);
	
}

