package com.valtech.carassignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valtech.carassignment.model.User;
@Service
public interface UserService {
	
	void postUser(User user);
	
	User getUser(int id);


}
