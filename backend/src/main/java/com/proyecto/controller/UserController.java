package com.proyecto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.beans.User;
import com.proyecto.model.UserModel;

@RestController
public class UserController {

	
	UserModel userModel = new UserModel();
	
	@PostMapping("/user")
	public User getUsuario(@RequestBody User user) {
		User u = new User();
		
		u = userModel.getUser(user.getUser());
		
		return u;
	}
	
	
	@PostMapping("/modifyUser")
	public String modifyUser(@RequestBody User user) {

		String resp = "";
		Boolean response = userModel.modifyUser(user);
		
		
		if(response) {
			resp = "El usuario se ha modificado correctamente.";
		}
		else {
			resp = "No se ha podido actualizar el usuario.";
		}
		
		return resp;
	}
	
	
	public Boolean validateUser(@RequestBody User user) {
		
		return true;
	}
}
