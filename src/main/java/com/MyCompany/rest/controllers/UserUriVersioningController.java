package com.MyCompany.rest.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyCompany.rest.dtos.UserDtoV1;
import com.MyCompany.rest.dtos.UserDtoV2;
import com.MyCompany.rest.entities.User;
import com.MyCompany.rest.exceptions.UserNotFoundException;
import com.MyCompany.rest.services.UserService;

@RestController
@RequestMapping("/versioning/uri/users")
public class UserUriVersioningController
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping({"/v1.0/{id}","/v1.1/{id}"})
	public UserDtoV1 getUserById1(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException
	{
		Optional<User> theoptionauser=userService.getUserById(id);
		
		if(!theoptionauser.isPresent())
		{
			throw new UserNotFoundException("User not found");
		}
		
		User theuser=theoptionauser.get();
		UserDtoV1 userDtov1=modelMapper.map(theuser, UserDtoV1.class);
		return userDtov1;
	}
	
	
	@GetMapping("/v2.0/{id}")
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException
	{
		Optional<User> theoptionauser=userService.getUserById(id);
		
		if(!theoptionauser.isPresent())
		{
			throw new UserNotFoundException("User not found");
		}
		
		User theuser=theoptionauser.get();
		UserDtoV2 userDtov2=modelMapper.map(theuser, UserDtoV2.class);
		return userDtov2;
	}
	
	
}