package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.User;
import com.hcl.service.RegistrationService;

@RestController
@CrossOrigin(origins = "localhost:4200")
public class RegistrationController 
{

	@Autowired
	private RegistrationService service;
	
	
	@PostMapping("/reg")
	public User registerUser(@RequestBody  User user) throws Exception
	{
		String tempEmailId=user.getEmailId();
		
		
		if(tempEmailId!=null && !"".equals(tempEmailId))
		{
			User userObj=service.feachUserByEmailId(tempEmailId);
			
			if(userObj !=null)
				throw new Exception("User with "+tempEmailId+" is already exists.");
		}
		
		User userObj=null;
		userObj =service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempEmailId=user.getEmailId();
		String tempPassword=user.getPassword();
		
		User userObj=null;
		if(tempEmailId != null && tempPassword !=null)
		{
		userObj=	service.feachUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		

		if(userObj ==null)
			throw new Exception("Bad credential. ");
		
		return userObj;
	}
	
}
