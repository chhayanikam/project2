package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ForumDAO;
import com.niit.model.Blog;
import com.niit.model.Forum;

@Transactional
@Service
@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addForum(Forum f) {
		try{
			sessionFactory.getCurrentSession().save(f);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean deleteForum(Forum f) {
		try{
			sessionFactory.getCurrentSession().delete(f);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean updateForum(Forum f) {
		try{
			sessionFactory.getCurrentSession().update(f);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public Forum getForum(int ForumId) {
		try{
			Session session=sessionFactory.openSession();
			Forum forum=session.get(Forum.class, ForumId);
			session.close();
			return forum;
		}
		catch(Exception e){
			return null;	
		}
	}

	public List<Forum> listForum() {
		try{
		String selectAllForum = "FROM Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllForum);		
		return query.getResultList();
		}
		catch(Exception e)
		{
		return null;
		}
	}

}
