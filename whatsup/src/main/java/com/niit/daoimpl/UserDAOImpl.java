package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;

import com.niit.model.User;

@Transactional
@Service
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean deleteUser(User user) {
		try{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean updateUser(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public User getUser(int userId) {
		try{
			Session session=sessionFactory.openSession();
			User user=session.get(User.class, userId);
			session.close();
			return user;
		}
		catch(Exception e){
			return null;	
		}
	}

	public List<User> listUser() {
		try{
			String selectAllUser = "FROM User";
			Query query = sessionFactory.getCurrentSession().createQuery(selectAllUser);		
			return query.getResultList();
			}
			catch(Exception e)
			{
			return null;
			}
	}

}
