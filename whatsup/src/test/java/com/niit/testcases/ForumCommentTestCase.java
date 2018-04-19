package com.niit.testcases;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.*;
import com.niit.model.*;
public class ForumCommentTestCase {
	private static AnnotationConfigApplicationContext context;
	private static BlogDAO blogDAO;
	private Blog blog;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDAO = (BlogDAO)context.getBean("blogDAO");
	}
 
	@Ignore
	@Test  // GREEN
	public void ListBlogTestCase() {
		assertEquals("Successfully fetched the list of blogs from the table!",1,blogDAO.listBlog().size());
	}


}
