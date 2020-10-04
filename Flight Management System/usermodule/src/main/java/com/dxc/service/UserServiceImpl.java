package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.IUserDao;
import com.dxc.entities.User;
import com.dxc.exceptions.UserNotFoundException;

import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User addUser(User user) {
		validateUser(user);
		user = userDao.save(user);
		return user;

	}

	private void validateUser(User user) {
		if(user==null) {
			throw new UserNotFoundException("user should not be null");
		}
		
	}

	@Override
	public User findUserById(int userId) {
		Optional<User> optional = userDao.findById(userId);
		if (!optional.isPresent()) {
			throw new UserNotFoundException("user not found for id=" + userId);
		}
		User user = optional.get();
		return user;
	}

	@Override
	public List<User> allUsers() {
		List<User> users = userDao.findAll();
		return users;
	}

	@Override
	public void deleteUser(int userId) {
		findUserById(userId);
		userDao.deleteById(userId);

	}

}
