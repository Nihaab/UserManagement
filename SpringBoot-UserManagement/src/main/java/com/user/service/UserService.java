package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService 
{
	public int addUser(User user);

	public List<User> getAllUsers();

	public User getUserById(String id);

	public int updateUser(User user);

	public int deleteById(String id);
}
