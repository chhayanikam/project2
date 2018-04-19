package com.niit.testcases;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.*;
import com.niit.model.*;

public class BlogTestCase {
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
		assertEquals("Successfully fetched the list of blogs from the table!",2,blogDAO.listBlog().size());
	}

	@Ignore
 	@Test  
	public void ListBlogByNameTestCase() {
		assertEquals("Successfully fetched the list of blogs from the table!",5,blogDAO.listBlogByName("Riya").size());
	}

	//@Ignore
 	@Test  
	public void IncrementLikesTestCase() {
 		Blog b=blogDAO.getBlog(123);
		assertEquals("Successfully Incremented the like!",true,blogDAO.incrementLikes(b));
	}
	
 	@Ignore
	@Test  // GREEN- sequence working 
	public void addBlogTestCase() {
		Date d=new Date();
		Blog b=new Blog();
		b.setBlogContent("Travel blog for nature loving people");	
		b.setCreatedDate(d);
		b.setBlogName("Travel");
		b.setStatus("Active");
		b.setUserName("Riya");	
		b.setLikes(0);
		blogDAO.addBlog(b);
		assertEquals("Successfully added blog",true,blogDAO.addBlog(b));
		
	}



	@Ignore
	@Test  //  GREEN
	public void DeleteBlogTestCase() {
		Blog b=blogDAO.getBlog(103);
		assertEquals("blog deleted",true,blogDAO.deleteBlog(b));
	}
	
	@Ignore
	@Test  //  GREEN
	public void UpdateBlogTestCase() {
		Date d=new Date();		
		Blog b=blogDAO.getBlog(4);
		b.setBlogContent("Travels Guide");
		b.setCreatedDate(d);
		b.setBlogName("Fox Guide");
		b.setStatus("A");
		b.setUserName("Chhaya Nikam");
		blogDAO.updateBlog(b);
		assertEquals("blog updated Successfully!",true,blogDAO.updateBlog(b));
	}
	
	@Ignore
	@Test  // GREEN
	public void RejectBlogTestCase()
	{
		Blog b=blogDAO.getBlog(107);				
		assertEquals("blog rejected!",true,blogDAO.rejectBlog(b));
	}
	
	@Ignore
	@Test  // GREEN
	public void ApproveBlogTestCase()
	{
		Blog b=blogDAO.getBlog(107);				
		assertEquals("blog Approved!",true,blogDAO.approveBlog(b));
	}
	
	}