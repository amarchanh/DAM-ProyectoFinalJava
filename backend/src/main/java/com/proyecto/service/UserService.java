package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.beans.User;
import com.proyecto.dao.UserDAO;
import com.proyecto.utils.PasswordUtils;

@Service
public class UserService {

	@Autowired	
	private UserDAO userDAO; 
	
//	@Autowired
//	private PasswordUtils passwordUtils;
	
	public User getUser(String username) {
		
		User u = new User();
		
		u = userDAO.getUser(username);
		
		return u;
	}
	
	
	public Boolean modifyUser(User user) {
		return userDAO.modifyUser(user);
	}
	
	
	public String createUser(String email) {
		
		String password = PasswordUtils.GenerateRandomPassword();
		
		return userDAO.createUser(email, password) == true ? password : null;
		
	}
}
