package com.monica.rest.webservices.restfulwebservices.user;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {
	@Autowired
	private UserDAOService userDaoService; 
	public static final Logger log=LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	@Override
	public void run(String... args) throws Exception {
	/*User user = new User("Monica",new Date());
	userDaoService.addUser(user);
	log.info("new user is created with id :"+ user.getId());*/
	}

}
