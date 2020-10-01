package com.dxc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.dto.CreateUserRequest;
import com.dxc.dto.UserDto;
import com.dxc.entities.User;
import com.dxc.exceptions.UserNotFoundException;
import com.dxc.service.IUserService;
import com.dxc.util.UserUtil;



@RestController
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	private IUserService userService;
	@Autowired
	private UserUtil userUtil;

	@PostMapping(value = "/addUser")
	public UserDto create(@Valid @RequestBody CreateUserRequest data) {
		String userName = data.getUserName();
		String userType = data.getUserType();
		String email = data.getEmail();
		long userPhone = data.getUserPhone();
		String password = data.getPassword();

		User user = new User(userType, userName, email, userPhone, password);
		user = userService.addUser(user);
		UserDto response = userUtil.userDto(user);
		return response;
	}

	@GetMapping("/get/{userId}")
	public UserDto findUserById(@PathVariable("userId") int userId) {
		User user = userService.viewUserById(userId);
		if(user==null) {
			throw new UserNotFoundException("enter valid id");
		}
		UserDto response = userUtil.userDto(user);
		return response;
		

	}

	@GetMapping("/viewall")
	public List<User> viewUser() {
		return userService.viewUser();
	}

	@DeleteMapping("/delete/{userId}")
	public void deleteUserById(@PathVariable("userId") int userId) {
		try {
			userService.deleteUser(userId);
			System.out.println("deleted successfully");
		} catch (Exception e) {
			System.out.println("user id not found");
		}
	}

}
