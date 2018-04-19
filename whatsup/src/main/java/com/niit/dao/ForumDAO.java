package com.niit.dao;

import java.util.List;

import com.niit.model.*;

public interface ForumDAO {
	public boolean addForum(Forum f);
	public boolean deleteForum(Forum f);
	public boolean updateForum(Forum f);
	public Forum getForum(int ForumId);
	public List<Forum>listForum();
}
