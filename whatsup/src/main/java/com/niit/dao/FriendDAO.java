package com.niit.dao;

import java.util.List;

import com.niit.model.*;

public interface FriendDAO {
	public boolean addFriend(Friend f);
	public boolean deleteFriend(Friend f);
	public boolean updateFriend(Friend f);
	public Friend getFriend(int FriendId);
	public List<Friend>listFriend();
}
