package com.niit.testcases;
import static org.junit.Assert.assertEquals;


import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.*;
import com.niit.model.*;
public class ForumTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ForumDAO forumDAO;
	private Forum forum;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDAO = (ForumDAO)context.getBean("forumDAO");
	}

	@Ignore
	@Test  // GREEN
	public void AddForumTestCase() {
 		Forum f=new Forum();
 		f.setDateOfCreation(new Date());
 		f.setUserId(113);
 		f.setForumName("Best Routes");
 		f.setForumContent("forum for discusseion");
 		assertEquals("Successfully added forum to the table!",true,forumDAO.addForum(f));
	}


	@Ignore
	@Test  // GREEN
	public void updateForumTestCase() {
 		Forum f=forumDAO.getForum(119);
 		f.setDateOfCreation(new Date());
 		f.setUserId(113);
 		f.setForumName("Best Routes explore");
 		f.setForumContent("forum for discusseion123");
 		assertEquals("Successfully updated forum to the table!",true,forumDAO.updateForum(f));
	}

	@Ignore
	@Test  // GREEN
	public void ListForumTestCase() {
 		assertEquals("Fetched the list from table!",1,forumDAO.listForum().size());
	}

	
}
