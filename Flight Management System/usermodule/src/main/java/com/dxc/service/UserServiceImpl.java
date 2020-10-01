package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.IUserDao;
import com.dxc.entities.User;
import com.dxc.exceptions.UserNotFoundException;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	@Override
	public User addUser(User user) {
		user = userDao.save(user);
		return user;

	}

	

	@Override
	public User viewUserById(int userId) {
		Optional<User> optional = userDao.findById(userId);
		if (!optional.isPresent()) {
			throw new UserNotFoundException("user not found for id=" + userId);
		}
		User user = optional.get();
		return user;
	}

	@Override
	public List<User> viewUser() {
		List<User> users = userDao.findAll();
		return users;
	}

	@Override
	public void deleteUser(int userId) {
		userDao.deleteById(userId);

	}

}
