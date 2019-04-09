package com.valtech.carassignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.carassignment.model.User;
import com.valtech.carassignment.repository.UserRepository;
import com.valtech.carassignment.service.UserService;

@Service
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

}
