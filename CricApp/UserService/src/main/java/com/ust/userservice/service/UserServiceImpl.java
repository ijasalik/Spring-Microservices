package com.ust.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.userservice.dao.CurrentMatchDao;
import com.ust.userservice.dao.UserDao;
import com.ust.userservice.dto.MyUserDetails;
import com.ust.userservice.entity.CurrentMatch;
import com.ust.userservice.entity.User;
import com.ust.userservice.exception.UserException;
@Service
public class UserServiceImpl implements UserService,UserDetailsService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private CurrentMatchDao currentMatchDao;

	@Override
	public User register(User userData) {
		User user= userDao.save(userData);
		return user;
		
	}

	@Override
	public List<CurrentMatch> getCurrentMatch() {
		
		return currentMatchDao.findAll();
	}



	@Override
	public User findByUserNameAndPassword(String username, String upassword) {
		User curruser= userDao.findByUserNameAndPassword(username, upassword);
		if(curruser==null) {
			throw new UserException("invalid id or password");
		}
		return curruser;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<User> user= userDao.findByUserName(username);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found :"+username));
	   return user.map(MyUserDetails::new).get();
	}

}
