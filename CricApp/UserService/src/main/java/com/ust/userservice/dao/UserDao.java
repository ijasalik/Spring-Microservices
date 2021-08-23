package com.ust.userservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.userservice.dto.UserDetails;
import com.ust.userservice.entity.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer> {


	User findByUserNameAndPassword(String username, String upassword);
	Optional<User> findByUserName(String username);
    


}
