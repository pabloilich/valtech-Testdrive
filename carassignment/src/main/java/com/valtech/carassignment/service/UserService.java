package com.valtech.carassignment.service;

import java.util.List;

import com.valtech.carassignment.model.User;

public interface UserService {
	
	void postUser(User user);
	
	User getUser(int id);
	
	List<User> getUSers();
	

}
