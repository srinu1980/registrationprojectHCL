package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.User;
import com.hcl.repository.RegistrationRepository;

@Service
public class RegistrationService 
{

	@Autowired
	RegistrationRepository repo;
	
	
	public User saveUser(User user)
	{
		return repo.save(user);
	}
	
	public User feachUserByEmailId(String emailId)
	{
		return repo.findByEmailId(emailId);
	}
	
	public User feachUserByEmailIdAndPassword(String emailId, String password)
	{
		return repo.findByEmailIdAndPassword(emailId, password);
	}
	
	
}
