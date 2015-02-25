package com.hlb.dblogging.security.users.service;



import javax.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hlb.dblogging.jpa.model.Users;
import com.hlb.dblogging.jpa.repository.UsersRepository;
import com.hlb.dblogging.security.users.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	

	@Resource
	private UsersRepository usersRepository;
		
	@Transactional(rollbackFor = { Exception.class })
	public Users create(Users users) {	
		 Users usersToBeCreated = users;
		 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 String hashedPassword = passwordEncoder.encode(usersToBeCreated.getPassword());
		 usersToBeCreated.setPassword(hashedPassword);
		return usersRepository.save(usersToBeCreated);
	}

	/*@Override
	@Transactional(rollbackFor=UsersNotFound.class)
	public Users delete(int id) throws UsersNotFound {	
		
		return null;
	}

	@Override
	public List<Users> findAll() {
		return null;
			//List<Users> usersList = usersRepository.findByIsEnabled(true);
		//return usersList;
	}

	@Override
	@Transactional(rollbackFor=UsersNotFound.class)
	public Users update(Users users) throws UsersNotFound {
		Users usersToBeUpdated = usersRepository.findOne(users.getId());
		
		if(usersToBeUpdated == null)
			 throw new UsersNotFound();
		usersToBeUpdated.setUsername(users.getUsername());
		usersToBeUpdated.setPassword(users.getPassword());
		usersToBeUpdated.setEnabled(users.isEnabled());
		usersToBeUpdated.setLastModifiedBy(users.getLastModifiedBy());
		usersToBeUpdated.setLastModifiedTime(users.getLastModifiedTime());
		usersRepository.saveAndFlush(usersToBeUpdated);		
		return usersToBeUpdated;
	}

	@Override	
	public Users registerUser(Users users) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(users.getPassword());
		users.setPassword(hashedPassword);
		Users createdUsers = usersRepository.save(users);
		return usersRepository.save(createdUsers);
	}
	
	@Override	
	public Users findById(int id) throws UsersNotFound {
		Users users = usersRepository.findOne(id);
		
		if(users == null)
			throw new UsersNotFound();
		
		return users;
	}
	
	
	
	@Override
	public Users findByUsername(String username) throws UsersNotFound {
		return null;
		Users users = usersRepository.findByUsername(username);
		
		if(users == null) {
			throw new UsersNotFound();
		}
		
		return users;
	}

	@Override
	public List<Users> findUsersByUsername(String username) {
			String usernameSearchTerm = "%" + username + "%";
		return usersRepository.findByUsernameLike(usernameSearchTerm);
		return null;
	}

	@Override
	public HashSet<String> getAccessRightsMapForUser(int userId) throws UsersNotFound {
		HashSet<String> accessRightsSet = new HashSet<String>();
		
		Users user = findById(userId);
		
		if(user == null) {
			throw new UsersNotFound();
		}
		return null;
		
		
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
		
		
		List<UserToAccessRights> userToAccessRightList = userToAccessRightsService.findByUserId(userId);
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
	public void changePassword(Users users, String oldPassword,
			String newPassword) throws ChangePasswordException, UsersNotFound{
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(!passwordEncoder.matches(oldPassword, users.getPassword())) {
			throw new ChangePasswordException("Invalid old password");
		}
		
		String hashedPassword = passwordEncoder.encode(newPassword);		
		users.setPassword(hashedPassword);		
		update(users);		
	}*/

	 
}