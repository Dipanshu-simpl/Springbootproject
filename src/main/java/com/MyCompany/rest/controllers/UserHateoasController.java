package com.MyCompany.rest.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.MyCompany.rest.entities.Order;
import com.MyCompany.rest.entities.User;
import com.MyCompany.rest.exceptions.UserNotFoundException;
import com.MyCompany.rest.repositories.UserRepository;
import com.MyCompany.rest.services.UserService;

@RestController
@RequestMapping("/hateoas/users")
@Validated
public class UserHateoasController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	// GetallUsers method.
	@GetMapping()
	public CollectionModel<User> getAllUsers() throws UserNotFoundException
	{
		List<User> theuser=userService.getAllUsers();
		for(User user:theuser)
		{
			// Self-link.
			
			long id=user.getId();
			Link selflink=ControllerLinkBuilder.linkTo(this.getClass()).slash(id).withSelfRel();
			
			user.add(selflink);
			
			// relationship links.
			
			CollectionModel<Order> orders=ControllerLinkBuilder.methodOn(OrderHateoasController.class).getAllOrders(id);
			Link orderlink=ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
			
		}
		
		
		CollectionModel<User> okuser=new CollectionModel<User>(theuser);
		return okuser;
	}
	
	
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id")  @Min(1)Long id)
	{
		try
		{
		Optional<User> theuser=userService.getUserById(id);
		User user=theuser.get();
		long userid=user.getId();
		Link selflink=ControllerLinkBuilder.linkTo(this.getClass()).slash(id).withSelfRel();
		user.add(selflink);
		
		EntityModel<User> finalresource=new EntityModel<User>(user);
		return finalresource;
		
		}
		catch(UserNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
}
