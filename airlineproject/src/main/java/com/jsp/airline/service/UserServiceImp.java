package com.jsp.airline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.UserDTO;
import com.jsp.airline.entity.User;
import com.jsp.airline.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public long registerUser(UserDTO user) 
	{
		User user2 = userRepository.save(User.builder().firstName(user.getFirstName())
													   .lastName(user.getLastName())
													   .mobileNumber(user.getMobileNumber())
													   .gender(user.getGender())
													   .userName(user.getUserName())
													   .password(user.getPassword()).build());
		return user2.getUserId();
	}

	@Override
	public UserDTO loginUser(String userName, String password) 
	{
		Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);
		if (user.isEmpty())
		{
			return null;
		}
		else
		{
			User user2 = user.get();
			UserDTO dto = UserDTO.builder().firstName(user2.getFirstName())
										   .lastName(user2.getLastName())
										   .mobileNumber(user2.getMobileNumber())
									       .gender(user2.getGender())
										   .userName(user2.getUserName())
										   .password(user2.getPassword())
										.build();
			return dto;
		}
	}
}
