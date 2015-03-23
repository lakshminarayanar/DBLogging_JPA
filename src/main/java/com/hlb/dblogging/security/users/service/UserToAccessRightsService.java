package com.hlb.dblogging.security.users.service;

import java.util.List;

import com.hlb.dblogging.jpa.model.AccessRights;
import com.hlb.dblogging.jpa.model.UserToAccessRights;

public interface UserToAccessRightsService {
	
	 UserToAccessRights create(UserToAccessRights userToAccessRights);
	 UserToAccessRights delete(int id);
	 List<UserToAccessRights> findAll();
	 UserToAccessRights update(UserToAccessRights userToAccessRights);
	 List<UserToAccessRights> findByUserId(int userId);
	 List<AccessRights> findAllAccessRights();
	 UserToAccessRights findByAccessRight(UserToAccessRights userToAccessRights);
}


