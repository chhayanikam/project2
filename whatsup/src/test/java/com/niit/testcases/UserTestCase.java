package com.niit.testcases;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.*;
import com.niit.model.*;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	//@Ignore
	@Test //Green
	public void AdUserTestCase() {
		User user = new User();
		user.setUserName("Chhaya");
		user.setBirthDate(new Date());
		user.setEmail("chhaya.nikam@gmail.com");
		user.setGender("F");
		user.setPassword("password");
		user.setPhoto(null);
		user.setStatus("Active");
		user.setUserRole("Admin");
		assertEquals("Successfully added the user!", true, userDAO.addUser(user));
	}
	
	@Ignore
	@Test // GREEN 
	 public void ListUserTestCase() {
	 assertEquals("Successfully fetched the list of users from the table!",1,
	  userDAO.listUser().size());
	 }
	 
	@Ignore 
	@Test // GREEN
	 public void UpdateUserTestCase() {
		User user= userDAO.getUser(109);
		user.setEmail("xyz.com");
		userDAO.updateUser(user);
	 assertEquals("Successfully updated the users from the table!",true,
	  userDAO.updateUser(user));
	 }
	
	@Ignore 
	@Test // GREEN
	 public void DeleteUserTestCase() {
		 User user=userDAO.getUser(109);
		assertEquals("Successfully deleted the users from the table!",true,
	  userDAO.deleteUser(user));
	 }

}
