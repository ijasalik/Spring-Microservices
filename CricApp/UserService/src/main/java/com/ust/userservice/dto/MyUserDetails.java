package com.ust.userservice.dto;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ust.userservice.entity.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

	private int id;
	private String firstName;
	private String LastName;
	private String password;
	private String userName;

    public MyUserDetails(User user){
    	
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.LastName = user.getLastName();
		this.password = user.getPassword();
		this.userName = user.getUserName();
    }



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
     return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
