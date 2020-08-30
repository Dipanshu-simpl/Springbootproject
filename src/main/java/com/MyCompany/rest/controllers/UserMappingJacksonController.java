package com.MyCompany.rest.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.MyCompany.rest.entities.User;
import com.MyCompany.rest.exceptions.UserNotFoundException;
import com.MyCompany.rest.services.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(value="/jacksonfilters/users")
@Validated
public class UserMappingJacksonController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public MappingJacksonValue getUserById(@PathVariable("id") @Min(1)Long id)
	{
		try
		{
		Optional<User> optionuser=userService.getUserById(id);
		
		User theuser=optionuser.get();
		Set<String> fields=new HashSet<String>();
		fields.add("username");
		fields.add("firstname");
		fields.add("id");
		fields.add("orders");
		
		
		
		FilterProvider filterProvider=new SimpleFilterProvider()
				                                .addFilter("userFilter",SimpleBeanPropertyFilter.
				                                                filterOutAllExcept(fields));
		
		MappingJacksonValue mapper=new MappingJacksonValue(theuser);
		mapper.setFilters(filterProvider);
		return mapper;
		
		
		}
		catch(UserNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	
	@GetMapping("/params/{id}")
	public MappingJacksonValue getUserById2(@PathVariable("id") @Min(1) Long id,@RequestParam Set<String> fields)
	{
		try {
		Optional<User> theuser=userService.getUserById(id);
		User okuser=theuser.get();
		
		FilterProvider thefilterprovider=new SimpleFilterProvider().
				                            addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
		
		MappingJacksonValue mapper=new MappingJacksonValue(okuser);
		mapper.setFilters(thefilterprovider);
		return mapper;
		}
		catch(UserNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	
	}
	
	
	}
	

