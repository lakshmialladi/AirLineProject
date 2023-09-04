package com.jsp.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.UserDTO;
import com.jsp.airline.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airlineproject/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/registeruser")
	public ResponseEntity<Long> registerUser(@RequestBody UserDTO user)
	{
		long i = userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(i);
	}
	
	@PostMapping("/loginuser/{userName}/{password}")
	public ResponseEntity<UserDTO> loginUser(@PathVariable("userName") String userName, @PathVariable("password") String password)
	{
		UserDTO user = userService.loginUser(userName, password);
		if (user != null)
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(userService.loginUser(userName, password));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
