package com.app.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.UserDto;
import com.app.repositories.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceimpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto user) {
		User user3 = this.mapper.map(user, User.class);
		user3.setAdded_date(new Date());	
		user3.setProfile_image("default.png");
		User user2 = this.userRepo.save(user3);
		return this.mapper.map(user2, UserDto.class);
	}

	@Override
	public List<UserDto> getAlluser() {
		List<User> all = this.userRepo.findAll();
		List<UserDto> list = all.stream()
				.map(mp -> this.mapper.map(mp, UserDto.class))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public UserDto getUserById(int id) {
		User user = this.userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		return this.mapper.map(user, UserDto.class);
	}

	@Override
	public UserDto upateUser(UserDto user, int id) {
		User user2 = this.userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		return this.mapper.map(user2, UserDto.class);
	}

	@Override
	public void deleteUser(int id) {
		User user = this.userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		this.userRepo.delete(user);
	}

}
