package com.hlb.dblogging.security.users.service;

import java.util.List;
import java.util.Set;

import com.hlb.dblogging.jpa.model.Role;

public interface RoleService {
	
	
	 Role create(Role role);
	 Role delete(int id);
	 List<Role> findAll();
	 Role update(Role role);
	 Role findById(int id);
	 Role findByRole(String role);
	 List<Role> findRoleByRoleName(String role);
	 Set<Role> findAllInSet();
	 List<String> findRoleNamesByUsername(String username);
}

