package com.valtech.carassignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.carassignment.model.User;
import com.valtech.carassignment.repository.UserRepository;
import com.valtech.carassignment.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void postUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User getUser(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getUSers() {
		// TODO Auto-generated method stub
		return null;
	}

}
