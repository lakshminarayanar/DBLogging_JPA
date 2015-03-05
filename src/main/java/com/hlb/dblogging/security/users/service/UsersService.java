package com.hlb.dblogging.security.users.service;

import java.util.HashSet;
import java.util.List;

import com.hlb.dblogging.jpa.model.Users;

public interface UsersService {

	  Users create(Users users);
	/*  Users delete(int id) throws UsersNotFound;
	  List<Users> findAll();
	  Users update(Users users) throws UsersNotFound;
	  Users findById(int id) throws UsersNotFound;
	  Users registerUser(Users users);
	  Users findByUsername(String username) throws UsersNotFound;
	  List<String> findUsersByUsername(String username);
	  HashSet<String> getAccessRightsMapForUser(int userId) throws UsersNotFound;
	  void changePassword(Users users, String oldPassword, String newPassword) throws ChangePasswordException, UsersNotFound;*/
	  List<Users> findAll();
	  List<Users> findAllUsers();
	  List<String> findUsersList(String username);

}
