package com.hlb.dblogging.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hlb.dblogging.jpa.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer>{

	/*@Query("select u from Users u where enabled = ?")
	 List<Users> findByIsEnabled(boolean isEnabled);
	
	@Query("select u from Users u where id = ?")
	List<Users> findById(int id);
	

	*/
	@Query("select u from Users u where username=? and enabled=1")
	Users findByUsername(String username);
	
	@Query("select u from Users u where username=? and enabled=0")
	Users findPreviouslyExistingUser(String username);
	
	@Query("select u  from Users u where enabled=1")
	List<Users> findListofUsers();
	
	@Query("select username from Users u where username like ? and enabled=1")
	List<String> findUserList(String username);
	
	@Query("select count(*) from Users where username=? and enabled=1")
	int findUsernameExists(String username);
		
	
	@Modifying  
	@Query("update Users u set enabled=0 where username=?")
	int deleteUser(String username);
}
