package com.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.controller.UserController;
import com.user.entity.User;
import com.user.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepo urepo;
	
	Logger logger =LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public int addUser(User user) 
	{
		logger.info("I'm in user service layer......");
		logger.info("User is....... "+user);
		
		if(user!=null)
		{
			urepo.save(user);
			logger.info("User Added.........!!!!!");
			return 1;
		}
		return 0;
	}

	@Override
	public List<User> getAllUsers() 
	{
		List<User> allUsers = urepo.findAll();
		//List<User> allUsers = null;
		
		
		if(allUsers!=null)
		{
			return allUsers;
		}
		return null;
	}

	@Override
	public User getUserById(String id) 
	{
		Optional<User> user = urepo.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		return null;
	}

	@Override
	public int updateUser(User user) 
	{
		User u = urepo.save(user);
		if(u!=null)
		{
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteById(String id) 
	{
		urepo.deleteById(id);
		if(urepo.findById(id).isPresent())
		{
			return 0;
		}
		return 1;
	}
}
