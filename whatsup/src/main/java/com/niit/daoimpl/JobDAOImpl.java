package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.niit.dao.JobDAO;
import com.niit.model.ApplyJob;
import com.niit.model.Job;

@Transactional
@Service
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addJob(Job job) {
		try{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean deleteJob(Job job) {
		try{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean updateJob(Job job) {
		try{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public Job getJob(int JobId) {
		try{
			Session session=sessionFactory.openSession();
			Job job=session.get(Job.class, JobId);
			session.close();
			return job;
		}
		catch(Exception e){
			return null;	
		}
	}


	public List<Job> listJob() {
		try{
			String selectAllJob = "FROM Job";
			Query query = sessionFactory.getCurrentSession().createQuery(selectAllJob);		
			return query.getResultList();
			}
			catch(Exception e)
			{
			return null;
			}
	}

	public boolean applyJob(ApplyJob job) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ApplyJob> getAppliedJobs() {
		// TODO Auto-generated method stub
		return null;
	}

}
