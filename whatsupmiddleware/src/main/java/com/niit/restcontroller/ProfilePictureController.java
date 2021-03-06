package com.niit.restcontroller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.dao.ProfileUpdateDAO;
import com.niit.model.ProfilePicture;
import com.niit.model.User;

@RestController
public class ProfilePictureController {
	@Autowired
	ProfileUpdateDAO profileUpdateDAO;
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public ResponseEntity<?> uploadPicture(@RequestParam(value="file")CommonsMultipartFile fileupload,HttpSession session)
	{
	
		User userDetail=(User)session.getAttribute("userdetail");
		
		if(userDetail==null) 
		{
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		else
		{
			ProfilePicture profilePicture=new ProfilePicture();
			profilePicture.setLoginname(userDetail.getUserName());
			profilePicture.setImage(fileupload.getBytes());
			profileUpdateDAO.save(profilePicture);
			System.out.println("line after profile save method called");
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/getImage/{loginname}")
	public @ResponseBody byte[] getProfilePic(@PathVariable("loginame") String loginname)
	{
		
		ProfilePicture profilePicture=profileUpdateDAO.getProfilePicture(loginname);
		
		if(profilePicture==null)
		{
			return null;
		}
		else
		{
			return profilePicture.getImage();
		}
	}

}
