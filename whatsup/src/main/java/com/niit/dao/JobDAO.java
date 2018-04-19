package com.niit.dao;

import java.util.List;
import com.niit.model.*;

public interface JobDAO {

	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public Job getJob(int JobId);
	public boolean applyJob(ApplyJob job);
	public List<ApplyJob>getAppliedJobs();
	public List<Job>listJob();
	
}
