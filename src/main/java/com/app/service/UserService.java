package com.app.service;

import java.util.List;

import com.app.entity.User;
import com.app.payload.UserDto;

public interface UserService {
	
	// add user(admin/normal)
	public UserDto createUser(UserDto user);
	// get all user
	public List<UserDto> getAlluser();
	// get user by id
	public UserDto getUserById(int id);
	// update user
	public UserDto upateUser(UserDto user , int id);
	// delete user
	public void deleteUser(int id);

}
