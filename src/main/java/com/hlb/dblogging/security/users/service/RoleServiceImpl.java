package com.hlb.dblogging.security.users.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlb.dblogging.exception.utility.BSLException;
import com.hlb.dblogging.jpa.model.AccessRights;
import com.hlb.dblogging.jpa.model.Role;
import com.hlb.dblogging.jpa.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	public static String role="ROLE_USER";
	
	@Resource
	private RoleRepository roleRepository;
	

	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	@Transactional(rollbackFor ={Exception.class,BSLException.class})
	public Role create(Role role) {
	 try{	
		Role roleToBeCreated = role;
		log.info("New Role is saving into database with Name :"+roleToBeCreated.getRole());
		return roleRepository.save(roleToBeCreated);
	}catch (Exception e) {
		log.error("Error while saving new Role :"+role.getRole(), e);
		throw new BSLException("err.role.create", e);
	}
}

	@Override
	@Transactional(rollbackFor=BSLException.class)
	public Role delete(int id){
	try{
		Role role = roleRepository.findOne(id);
		
		if(role != null){			
		role.setDeleted(true);
		roleRepository.save(role);
	}	
		return role;
	}catch(Exception e) {
		log.error("Error while deleting new Role :"+id, e);
		throw new BSLException("err.role.delete", e);
	}
}	
	

	@Override
	public List<Role> findAll() {
		List<Role> resultList = roleRepository.findByIsDeleted(0);
		return resultList;
	}
	
	@Override
	public Set<Role> findAllInSet() {
		Set<Role> resultSet = roleRepository.findAllInSet();
		return resultSet;
	}

	@Override
	@Transactional(rollbackFor={Exception.class,BSLException.class})
	public Role update(Role role){
	 try{	
		Role roleToBeUpdated = roleRepository.findOne(role.getId());		
		if(roleToBeUpdated != null){			
		roleToBeUpdated.setId(role.getId());
		roleToBeUpdated.setRole(role.getRole());
		roleToBeUpdated.setDescription(role.getDescription());
		roleToBeUpdated.setLastModifiedBy(role.getLastModifiedBy());
		roleToBeUpdated.setLastModifiedTime(new Date());
		Set<AccessRights> accessRightsSet = new HashSet<AccessRights>();
		accessRightsSet.addAll(role.getAccessRights());
		roleToBeUpdated.setAccessRights(accessRightsSet);
		roleRepository.save(roleToBeUpdated);		
		}	
		return roleToBeUpdated;
	}catch (Exception e) {
		log.error("Error while updating Role :"+role.getRole(), e);
		throw new BSLException("err.role.update", e);
	}
}

	
	@Override
	public Role findByRole(String role)  {
		Role foundRole = roleRepository.findByRole(role);
		
		if(foundRole == null)
			throw new BSLException();
		
		return foundRole;
	}
	
	@Override
	@Transactional
	public Role findById(int id) {
	    Role role = roleRepository.findOne(id);
	     
	       if(role == null)
	    	   throw new BSLException();	     
		return role;
	}

	@Override
	public List<Role> findRoleByRoleName(String role) {
		String roleSearchTerm = "%" + role + "%";
		return roleRepository.findByRoleLike(roleSearchTerm);
	}

	@Override
	public List<String> findRoleNamesByUsername(String username) {
		List<String> roleNameList = roleRepository.findRoleNamesByUsername(username);
		return roleNameList;
	}	

	
}

