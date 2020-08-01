package com.proyecto.model;

import javax.annotation.Resource;

import com.proyecto.beans.User;
import com.proyecto.dao.UserDAO;

@Resource
public class UserModel {

	
	UserDAO userDAO = new UserDAO();
	
	public User getUser(String username) {
		
		User u = new User();
		
		u = userDAO.getUser(username);
		
		return u;
	}
	
	
	public Boolean modifyUser(User user) {
		return userDAO.modifyUser(user);
	}
}
