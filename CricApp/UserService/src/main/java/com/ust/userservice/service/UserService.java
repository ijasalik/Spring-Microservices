package com.ust.userservice.service;

import java.util.List;

import com.ust.userservice.dto.UserDetails;
import com.ust.userservice.entity.CurrentMatch;
import com.ust.userservice.entity.User;

public interface UserService {

	User register(User userData);


	List<CurrentMatch> getCurrentMatch();





	User findByUserNameAndPassword(String username, String upassword);

}
