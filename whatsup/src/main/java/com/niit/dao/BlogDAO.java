package com.niit.dao;
import java.util.List;

import com.niit.model.*;
public interface BlogDAO {
public boolean addBlog(Blog b);
public boolean deleteBlog(Blog b);
public boolean updateBlog(Blog b);
public Blog getBlog(int blogId);
public boolean approveBlog(Blog blogId);
public boolean rejectBlog(Blog blog);
public List<Blog>listBlogByName(String byName);
public List<Blog>listBlog();
public boolean incrementLikes(Blog blog);
}
