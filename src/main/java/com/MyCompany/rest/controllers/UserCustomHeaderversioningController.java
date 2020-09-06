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
@RequestMapping("/versioning/headers/users")
public class UserCustomHeaderversioningController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value="/{id}", headers="API-VERSION=1")
	public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException
	{
		
		Optional<User> useroptional=userService.getUserById(id);
		
		if(!useroptional.isPresent())
		{
			throw new UserNotFoundException("User not found");
		}
		
		User theuser=useroptional.get();
		
		UserDtoV1 userDtov1=modelMapper.map(theuser, UserDtoV1.class);
		return userDtov1;
	}
	
	
	@GetMapping(value="/{id}",headers="API-VERSION=2")
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException
	{
		
		Optional<User> useroptional=userService.getUserById(id);
		
		if(!useroptional.isPresent())
		{
			throw new UserNotFoundException("User not found");
		}
		
		User theuser=useroptional.get();
		
		UserDtoV2 userDtov2=modelMapper.map(theuser, UserDtoV2.class);
		return userDtov2;
	}
}
