package com.MyCompany.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyCompany.rest.entities.User;
import com.MyCompany.rest.repositories.UserRepository;

@Service
public class UserService {

	// Injecting dependency
	
	@Autowired
	private UserRepository userRepository;
	
	// Creating a method to get all the users.
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	
	// createUser method
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	
	// getUserById method
	
	public Optional<User> getUserById(Long id)
	{
		Optional<User> user=userRepository.findById(id);
		return user;
	}
	
	
	// updateUserById
	
	public User updateUserById(Long id, User user)
	{
		user.setId(id);
		return userRepository.save(user);
	}
	
	//  deleteUserById
	
	public void deleteUserById(Long id)
	{
	    if(userRepository.findById(id).isPresent())
	    {
	    	userRepository.deleteById(id);
	    }
	}
	
	// getUserByUsername
	
	
	public User getUserByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
	
	
	
}
