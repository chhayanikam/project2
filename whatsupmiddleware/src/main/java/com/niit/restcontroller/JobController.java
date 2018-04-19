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
public class JobController {

	@Autowired
	private JobDAO jobDAO;

	@PostMapping(value = "/addJob")
	public ResponseEntity<String> addJob(@RequestBody Job job) {
		Date d = new Date();
		job.setLastDateApply(new Date());
		if (jobDAO.addJob(job)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}
	
		@GetMapping("/deleteJob/{jobId}")
	public ResponseEntity<String> deleteJob(@PathVariable("jobId") int JobId) {
		Job job=jobDAO.getJob(JobId);
		
		if (jobDAO.deleteJob(job)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}
	/*//success:postman
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> listusers = userDAO.listUser();
		
		if (listusers.size() > 0) {
			return new ResponseEntity<List<User>>(userDAO.listUser(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(userDAO.listUser(), HttpStatus.NOT_FOUND);
		}
	}

	//success:postman
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") int userId) {
		User user=userDAO.getUser(userId);

		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
	}*/

}
