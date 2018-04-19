package com.niit.testcases;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.*;
import com.niit.model.*;
public class JobTestCase {
	private static AnnotationConfigApplicationContext context;
	private static JobDAO jobDAO;
	private Job job;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDAO = (JobDAO)context.getBean("jobDAO");
	}
 
	
// Tested :Green
	@Ignore
	@Test  
	public void AddJobTestCase() {
		Job job=new Job();
		job.setDesignation("Manager");
		
		job.setSalary(30000);
		job.setLocation("Mumbai");
		assertEquals("Successfully fetched the list of friends from the table!",true,
				jobDAO.addJob(job));
	}

	@Ignore
	@Test  
	public void ListJobTestCase() {
		assertEquals("Successfully fetched the list of friends from the table!",1,
				jobDAO.listJob().size());
	}


	@Ignore
	@Test  // green
	public void UpdateJobTestCase() {
		Job job=jobDAO.getJob(115);
		job.setDesignation("Analyst");
		job.setDesignation("Ana");
		job.setSalary(40000);
		job.setCompany("abcl");		
		assertEquals("Successfully fetched the list of friends from the table!",true,
				jobDAO.updateJob(job));
	}
	
	
	
}
