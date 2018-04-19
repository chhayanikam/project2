package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.FriendDAO;
import com.niit.model.Blog;
import com.niit.model.Friend;

@Transactional
@Service
@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addFriend(Friend f) {
		try{
			sessionFactory.getCurrentSession().save(f);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean deleteFriend(Friend f) {
		try{
			sessionFactory.getCurrentSession().delete(f);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public boolean updateFriend(Friend f) {
		try{
			sessionFactory.getCurrentSession().update(f);
			return true;
		}
		catch(Exception e){
			return false;	
		}
	}

	public Friend getFriend(int FriendId) {
		try{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class, FriendId);
			session.close();
			return friend;
		}
		catch(Exception e){
			return null;	
		}
	}

	public List<Friend> listFriend() {
		try{
			String selectAllFriend = "FROM Friend";
			Query query = sessionFactory.getCurrentSession().createQuery(selectAllFriend);		
			return query.getResultList();
			}
			catch(Exception e)
			{
			return null;
			}
	}

}
