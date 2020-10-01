package com.dxc.service;

import java.util.List;

import com.dxc.entities.User;

public interface IUserService {
	public User addUser(User user);

	public User viewUserById(int userId);

	public List<User> viewUser();

	public void deleteUser(int userId);
	

}
