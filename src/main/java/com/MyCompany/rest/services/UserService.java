package com.MyCompany.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.MyCompany.rest.entities.User;
import com.MyCompany.rest.exceptions.UserExistsException;
import com.MyCompany.rest.exceptions.UserNotFoundException;
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
	
	public User createUser(User user) throws UserExistsException
	{
		User theuser=userRepository.findByUsername(user.getUsername());
		if(theuser!=null)
		{
			throw new UserExistsException("User already exists. Please enter new value");
		}
		return userRepository.save(user);
	}
	
	
	// getUserById method
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException
	{
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) 
		{
			throw new UserNotFoundException("User not found in user repository.");
			
		}
		
		
		return user;
	}
	
	
	// updateUserById
	
	public User updateUserById(Long id, User user) throws UserNotFoundException
	{
		
		Optional<User> theuser=userRepository.findById(id);
		if(!theuser.isPresent())
		{
			throw new UserNotFoundException("User not Found in the repository. Please provide the correct id");
		}
		
		
		
		user.setId(id);
		return userRepository.save(user);
	}
	
	//  deleteUserById
	
	public void deleteUserById(Long id)
	{
	    Optional<User> theuser=userRepository.findById(id);
	    if(!theuser.isPresent())
	    {
	    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in the repository. Please check and provide the correct user id");
	    }
	    
	    userRepository.deleteById(id);
	}
	
	// getUserByUsername
	
	
	public User getUserByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
	
	
	
}
