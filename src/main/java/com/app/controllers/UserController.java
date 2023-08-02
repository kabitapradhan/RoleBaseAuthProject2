package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.payload.UserDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<UserDto>  createUser(@RequestBody UserDto user) {
		UserDto user2 = this.userService.createUser(user);
		return new ResponseEntity<UserDto>(user2 , HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>>  getAllUser(){
		List<UserDto> list = this.userService.getAlluser();
		return new ResponseEntity<List<UserDto>>(list , HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId){
		UserDto user = this.userService.getUserById(userId);
		
		return new ResponseEntity<UserDto>(user , HttpStatus.OK);
	}

}
