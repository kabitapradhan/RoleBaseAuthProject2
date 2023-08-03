package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repositories.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// load user from database
		User user = this.userRepo.findByEmail(username).orElseThrow(()-> new RuntimeException("User Not Found"));
		System.out.println("CustomUserDetailsService page");
		System.out.println(user.getEmail() + " and pass : " + user.getPassword());
		return user;
	}

}
