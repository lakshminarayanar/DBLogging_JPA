package com.hlb.dblogging.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hlb.dblogging.jpa.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer>{

	/*@Query("select u from Users u where deleted = ?")
	 List<Users> findByIsEnabled(boolean isEnabled);
	
	@Query("select u from Users u where id = ?")
	List<Users> findById(int id);
	

	*/
	@Query("select u from Users u where username=? and deleted=0")
	Users findByUsername(String username);
	
	@Query("select u from Users u where username=? and deleted=1")
	Users findPreviouslyExistingUser(String username);
	
	@Query("select u  from Users u where deleted=0")
	List<Users> findListofUsers();
	
	@Query("select username from Users u where username like ? and deleted=0")
	List<String> findUserList(String username);
	
	@Query("select count(*) from Users where username=? and deleted=0")
	int findUsernameExists(String username);
		
	
	@Modifying  
	@Query("update Users u set deleted=0 where username=?")
	int deleteUser(String username);
}
