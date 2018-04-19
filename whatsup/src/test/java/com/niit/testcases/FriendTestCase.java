package com.niit.testcases;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.*;
import com.niit.model.*;
public class FriendTestCase {
	private static AnnotationConfigApplicationContext context;
	private static FriendDAO friendDAO;
	private Friend friend;

	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		friendDAO = (FriendDAO)context.getBean("friendDAO");
	}

	@Ignore
	@Test  // GREEN
	public void ListBlogTestCase() {
	//	assertEquals("Successfully fetched the list of blogs from the table!",1,blogDAO.listBlog().size());
	}


}
