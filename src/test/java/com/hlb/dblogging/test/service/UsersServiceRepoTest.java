package com.hlb.dblogging.test.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hlb.dblogging.jpa.repository.AuditMasterRepository;
import com.hlb.dblogging.jpa.repository.UsersRepository;
import com.hlb.dblogging.jpa.service.AuditMasterService;
import com.hlb.dblogging.security.users.service.UsersService;




@ContextConfiguration(locations="classpath:META-INF/spring-jpa.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UsersServiceRepoTest {

	@Autowired
	UsersRepository repo;
	
	
	@Autowired
	UsersService repo1;

	
	@Autowired
	AuditMasterRepository auditRepo;
	
	@Autowired
	AuditMasterService auditService;
	
	@Test
	public void test() {
	
	/*Users users=new Users();
	List<String> s1=null;	
	s1=repo1.findUsersList("y");
	System.out.println("what is tiz "+s1);
	*/
	auditService.getListOfMessagesByTime(new Date());
		
	}

}
