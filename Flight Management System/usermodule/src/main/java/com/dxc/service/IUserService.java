package com.dxc.service;

import java.util.List;

import com.dxc.entities.User;

public interface IUserService {
	public User addUser(User user);

	public User findUserById(int userId);

	public List<User> allUsers();

	public void deleteUser(int userId);
	

}
