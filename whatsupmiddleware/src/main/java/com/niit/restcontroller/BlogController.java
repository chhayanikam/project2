package com.niit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.niit.dao.*;
import com.niit.model.*;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

	@Autowired
	private BlogDAO blogDAO;

	@GetMapping("/demo1")
	public ResponseEntity<String> demopurpose() {
		System.out.println("In rest controller");
		return new ResponseEntity<String>("Demo data", HttpStatus.OK);
	}

	// Tested:Success :add a blog with postman
	@PostMapping(value = "/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog) {
		Date d = new Date();
		blog.setCreatedDate(d);
		blog.setLikes(0);
		blog.setUserName("Chhaya");
		blog.setStatus("A");
		// System.out.println(blog.getBlogContent() + " " + blog.getBlogName());
		if (blogDAO.addBlog(blog)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}

	}

	// Tested:Success :postman
	@GetMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.deleteBlog(blog)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}
	// Tested:Success :: postman
	@GetMapping("/incrementLikes/{blogId}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.incrementLikes(blog)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}

	// Tested:Success :get all blogs
	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getAllBlogs() {
		List<Blog> listblogs = blogDAO.listBlog();
		if (listblogs.size() > 0) {
			return new ResponseEntity<List<Blog>>(blogDAO.listBlog(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Blog>>(blogDAO.listBlog(), HttpStatus.NOT_FOUND);
		}
	}
// Tested:Success :get a single blog
	@GetMapping("/getBlog/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);

		if (blog != null) {
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		} else {
			return new ResponseEntity<Blog>(blog, HttpStatus.NOT_FOUND);
		}
	}

}
