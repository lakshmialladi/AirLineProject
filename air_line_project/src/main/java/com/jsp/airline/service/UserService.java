package com.jsp.airline.service;

import com.jsp.airline.dto.UserDTO;

public interface UserService 
{
	long registerUser(UserDTO user);
	
	UserDTO loginUser(String userName, String password);
}