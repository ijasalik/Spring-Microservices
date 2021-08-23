package com.ust.userservice.util;

import com.ust.userservice.dto.UserDetails;
import com.ust.userservice.entity.User;

public class UserUtil {

	public static UserDetails toDetails(User user) {

		return new UserDetails(user.getId(),user.getFirstName(),user.getLastName(),user.getPassword());
	}

}
