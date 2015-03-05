package com.hlb.dblogging.test.service;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hlb.dblogging.jpa.model.Users;
import com.hlb.dblogging.jpa.repository.UsersRepository;
import com.hlb.dblogging.security.users.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-jpa.xml")
public class UsersServiceRepoTest {

	@Autowired
	UsersRepository repo;
	
	@Autowired
	UsersService repo1;
	
	@Test
	public void test() {
	
	Users users=new Users();
	List<String> s1=null;	
	//users.setCreatedBy("me");
	//users.setLastModifiedBy("Mastermind");
	//users.setUsername("vicky");
	//users.setPassword("p@ssword");
	//repo.findUserList("admin");
	s1=repo1.findUsersList("vic");
	System.out.println("what is tiz "+s1);
	}

}
