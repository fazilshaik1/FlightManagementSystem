package com.dxc.util;

import org.springframework.stereotype.Component;

import com.dxc.dto.UserDto;
import com.dxc.entities.User;

@Component
public class UserUtil {
	public UserDto userDto(User user) {
		UserDto dto = new UserDto(user.getUserId(), user.getUserName(), user.getUserType(), user.getEmail(),
				user.getUserPhone(), user.getPassword());
		return dto;
	}

}
