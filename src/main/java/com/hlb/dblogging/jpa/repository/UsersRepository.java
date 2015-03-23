package com.hlb.dblogging.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hlb.dblogging.jpa.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer>{

	/*@Query("select u from Users u where enabled = ?")
	 List<Users> findByIsEnabled(boolean isEnabled);
	
	@Query("select u from Users u where id = ?")
	List<Users> findById(int id);
	

	*/
	@Query("select u from Users u where username=?")
	Users findByUsername(String username);
	
	@Query("select u  from Users u")
	List<Users> findListofUsers();
	
	@Query("select username from Users u where username like ?")
	List<String> findUserList(String username);
	
	@Query("select count(*) from Users where username=?")
	int findUsernameExists(String username);
		
	
}
