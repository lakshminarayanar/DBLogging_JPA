package com.hlb.dblogging.security.users.service;



import java.util.ArrayList;
import java.util.List;

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

	
	/*@Override
	]

	@Override	
	public Users registerUser(Users users) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(users.getPassword());
		users.setPassword(hashedPassword);
		Users createdUsers = usersRepository.save(users);
		return usersRepository.save(createdUsers);
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