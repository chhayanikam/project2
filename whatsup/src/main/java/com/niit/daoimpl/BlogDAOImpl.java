package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

@Transactional
@Service
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addBlog(Blog b) {
		try{
			sessionFactory.getCurrentSession().save(b);
			return true;
		}
		catch(Exception e){
			return false;	
		}
		// TODO Auto-generated method stub
		
	}

// tested:success in postman
	public boolean deleteBlog(Blog b) {
		try{
			sessionFactory.getCurrentSession().delete(b);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean updateBlog(Blog b) {
		try{
			sessionFactory.getCurrentSession().update(b);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}
	//tested:success in postman
	public Blog getBlog(int blogId) {
		try{
			Session session=sessionFactory.openSession();
			Blog blog=session.get(Blog.class, blogId);
			session.close();
			return blog;
		}
		catch(Exception e){
			return null;	
		}
	}

	public boolean approveBlog(Blog blog) {
		try{
			blog.setStatus("Approved");			
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e){
			return false;	
		}		
	}

	public boolean rejectBlog(Blog blog) {
		try{
			blog.setStatus("NA");			
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e){
			return false;	
		}		
	}

	//tested:success in postman
	public List<Blog> listBlog() {
		String selectAllBlogs = "FROM Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllBlogs);		
		return query.getResultList();
	}

	public List<Blog> listBlogByName(String byName) {
		String selectAllBlogs = "FROM Blog where UserName=:byName";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllBlogs);	
		query.setParameter("byName",byName);
		return query.getResultList();
	}
	//tested:success in postman
	public boolean incrementLikes(Blog blog) {
		try{
			blog.setLikes(blog.getLikes()+1); // increment Like			
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e){
			return false;	
		}		
	}

}
