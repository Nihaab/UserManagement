package com.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping(value = "/user/api")
public class UserController 
{
//================ In Web Mvc we use to send and get data using web pages in rest application
//	we are using JSON Payload====================
	
	
	
	@Autowired
	private UserService us;
	
	Logger logger =LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(value = "/addUser")
	public ResponseEntity<?> userAdd(@RequestBody User user)
	{
		//System.out.println(user);
		logger.info("User Details: "+user);
		
		int result = us.addUser(user);
		if(result>0)
		{
			return new ResponseEntity(user,HttpStatus.CREATED);
		}
			return new ResponseEntity("User not found.....",HttpStatus.NOT_FOUND);
		
	}
	
	//getting users(data) from server
	@GetMapping("/getUsers")
	public ResponseEntity<?> getUser()
	{
		List<User> allUsers = us.getAllUsers();
		if(allUsers!=null)
		{
			return new ResponseEntity(allUsers,HttpStatus.OK);
		}
		
		return new ResponseEntity("Users not found....",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<?> getSingleUser(@PathVariable String id)
	{
		User user = us.getUserById(id);
		if(user!=null)
		{
			return new ResponseEntity(user,HttpStatus.OK);
		}
		
			return new ResponseEntity("User not found.....",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateUser")
	//payload(user) postman se jayega
	public ResponseEntity<?> updateUserDetails(@RequestBody User user)
	{
		int updatedUser = us.updateUser(user);
		if(updatedUser>0)
		{
			return new ResponseEntity(user,HttpStatus.OK);
		}
			return new ResponseEntity("User not found/updated.....",HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id)
	{
		int deleteById = us.deleteById(id);
		if(deleteById>0)
		{
			return new ResponseEntity("User Deleted Successfully...",HttpStatus.OK);
		}
		return new ResponseEntity("User not found....",HttpStatus.NO_CONTENT);
	}
}
