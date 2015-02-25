package com.hlb.dblogging.test.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hlb.dblogging.jpa.model.Users;
import com.hlb.dblogging.jpa.repository.UsersRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-jpa.xml")
public class UsersServiceRepoTest {

	@Autowired
	UsersRepository repo;
	
	@Test
	public void test() {
	
	Users users=new Users();
		
	users.setCreatedBy("Vicky");
	users.setLastModifiedBy("Mastermind");
	users.setUsername("admin");
	users.setPassword("p@ssword");
	repo.save(users);
	}

}
