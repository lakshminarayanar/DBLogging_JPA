package com.hlb.dblogging.security.users.service;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlb.dblogging.jpa.model.AccessRights;
import com.hlb.dblogging.jpa.model.Role;
import com.hlb.dblogging.jpa.model.UserToAccessRights;
import com.hlb.dblogging.jpa.model.Users;
import com.hlb.dblogging.jpa.repository.UserToAccessRightsRepository;
import com.hlb.dblogging.jpa.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	

	@Resource
	private UsersRepository usersRepository;
	
	@Resource
	private UserToAccessRightsRepository userToAccessRightsRepository;
		
	
	@Transactional(rollbackFor = { Exception.class })
	public Users create(Users users) {	
		 Users usersToBeCreated = users;
		 //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 //String hashedPassword = passwordEncoder.encode(usersToBeCreated.getPassword());
		 //usersToBeCreated.setPassword(hashedPassword);
		return usersRepository.save(usersToBeCreated);
	}
	/*@Override
	public List<Users> findAll() {
		return null;
			List<Users> usersList = usersRepository.findByIsEnabled(true);
		//return usersList;
	}*/
	@Override
	public List<Users> findAllUsers () {
		
		return usersRepository.findListofUsers();
	}
	
	@Override
	public List<String> findUsersList(String username) {
		 List<String> s1 = new ArrayList<String>();
		
		String usernameSearchTerm = username + "%";
		s1= usersRepository.findUserList(usernameSearchTerm);
		
		
		return s1;
		}
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean findUserExistInApplication(String username) {
		int count = usersRepository.findUsernameExists(username);
		if(count==1)
			return true;
		
		return false;
	}
	
	@Override
	public HashSet<String> getAccessRightsMapForUser(String userId)  {
		HashSet<String> accessRightsSet = new HashSet<String>();
		
		Users user = usersRepository.findByUsername(userId);
		
		
		
		
		Set<Role> roleSet =  user.getUserRoles();
		
		Iterator<Role> roleIterator = roleSet.iterator();
		while(roleIterator.hasNext()) {
			Role currentRole = roleIterator.next();
			Set<AccessRights> currentRoleAccessRightSet = currentRole.getAccessRights();
			Iterator<AccessRights> currentRoleAccessRightIterator = currentRoleAccessRightSet.iterator();
			while(currentRoleAccessRightIterator.hasNext()) {
				AccessRights currentAccessRights = currentRoleAccessRightIterator.next();
				accessRightsSet.add(currentAccessRights.getAccessRights());
			}
		}
		
		List<UserToAccessRights> userToAccessRightList = userToAccessRightsRepository.findByUserId(user.getId());
		Iterator<UserToAccessRights> userToAccessRightIterator = userToAccessRightList.iterator();
		while(userToAccessRightIterator.hasNext()) {
			UserToAccessRights currentUserToAccessRights = userToAccessRightIterator.next();
			AccessRights currentAccessRights = currentUserToAccessRights.getAccessRights();
			if(accessRightsSet.contains(currentAccessRights.getAccessRights())) {
				if(currentUserToAccessRights.isEnabled() == true){
				accessRightsSet.add(currentAccessRights.getAccessRights());
			} else if(currentUserToAccessRights.isEnabled() == false) {
				accessRightsSet.remove(currentAccessRights.getAccessRights());
			}
		}else {
			if(currentUserToAccessRights.isEnabled() == true){
				accessRightsSet.add(currentAccessRights.getAccessRights());
			} 
		}
		}
		return accessRightsSet;
	}

	
	@Override
	@Transactional
	public void changePassword(Users users, String oldPassword,
			String newPassword){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(!passwordEncoder.matches(oldPassword, users.getPassword())) {
			throw new RuntimeException("Invalid old password");
		}
		
		String hashedPassword = passwordEncoder.encode(newPassword);		
		users.setPassword(hashedPassword);		
		update(users);		
	}
	@Override
	@Transactional
	public Users update(Users users) {
		Users usersToBeUpdated = usersRepository.findOne(users.getId());
		
		if(usersToBeUpdated == null)
			 throw new RuntimeException("Username not found");
		usersToBeUpdated.setUsername(users.getUsername());
		usersToBeUpdated.setPassword(users.getPassword());
		usersRepository.save(usersToBeUpdated);		
		return usersToBeUpdated;
	}

	 
}