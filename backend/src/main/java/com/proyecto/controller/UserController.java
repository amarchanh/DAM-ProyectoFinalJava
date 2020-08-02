package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.beans.User;
import com.proyecto.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "User Controller")
public class UserController {

	@Autowired
	UserService userService;// = new UserService();

	@ApiOperation(value = "Información del usuario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Funca") })

	@PostMapping("/userInfo")
	public User getUsuario(@RequestBody final User user) {
		User u = new User();

		u = userService.getUser(user.getUser());

		return u;
	}

	@ApiOperation(value = "Modifica el usuario")
	@PostMapping("/modifyUser")
	public String modifyUser(@RequestBody final User user) {

		String resp = "";
		Boolean response = userService.modifyUser(user);

		if (response) {
			resp = "El usuario se ha modificado correctamente.";
		} else {
			resp = "No se ha podido actualizar el usuario.";
		}

		return resp;
	}

	@GetMapping("/validateUser")
	@ApiOperation(value = "Valida al usuario")
	public Boolean validateUser(@RequestParam final String username) {

		return true;
	}

	@ApiOperation(value = "Crea al usuario")
	@PostMapping("/createUser")
	public String createUser(final User user) {

		String password = userService.createUser(user.getUser());
		
		return password;
	}
}
