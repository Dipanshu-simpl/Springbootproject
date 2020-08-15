package com.MyCompany.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyCompany.rest.entities.User;
import com.MyCompany.rest.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	
	// Autowire the userService.
	@Autowired
	private UserService userService;
	
	// method to getAll Users
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	// Method to add a createUser
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	
	// Method to get a user by id.
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id")  Long id)
	{
		return userService.getUserById(id);
	}
	
	
	// Method to update user by ID
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user)
	{
		return userService.updateUserById(id,user);
	}
	
	
	// Delete a user by ID
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id)
	{
		 userService.deleteUserById(id);
	}
	
	// get user by username
	
	@GetMapping("/users/byusername/{username}")
	public User getUserByUsername(@PathVariable("username") String username)
	{
		return userService.getUserByUsername(username);
	}
	
}
