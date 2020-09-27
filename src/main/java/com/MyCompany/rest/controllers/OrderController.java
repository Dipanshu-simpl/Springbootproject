package com.MyCompany.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.MyCompany.rest.entities.Order;
import com.MyCompany.rest.entities.User;
import com.MyCompany.rest.exceptions.UserNotFoundException;
import com.MyCompany.rest.repositories.OrderRepository;
import com.MyCompany.rest.repositories.UserRepository;


@RestController
@RequestMapping(value="/users")
public class OrderController {

	// DI
	@Autowired
	private UserRepository userRepository;
	
	
	// Adding comment here. adding DI for OrderRepository
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable("userid") Long userid) throws UserNotFoundException
	{
     		
		Optional<User> user=userRepository.findById(userid);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("User is not there is the respository");
		}
		
		return user.get().getOrders();
		
	}
	
	
	//Create an order.
	
	@PostMapping("/{userid}/orders")
	public void createOrder(@PathVariable("userid") Long userid, @RequestBody Order order) throws UserNotFoundException
	{
		Optional<User> user =userRepository.findById(userid);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("user not exists!!");
		}
		
		User okuser=user.get();
		order.setUser(okuser);
		orderRepository.save(order);
	}	
	
	
	@GetMapping("/{userid}/orders/{orderid}")
	public Long getOrderByOrderId(@PathVariable("userid") Long id, @PathVariable("orderid") Long ordid) throws UserNotFoundException{
		
		Optional<User> theuser=userRepository.findById(id);
		if(!theuser.isPresent())
		{
			throw new UserNotFoundException("This user not exists");
		}
		
		Optional<Order> ord=orderRepository.findById(ordid);
		if(!ord.isPresent())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not exits with user");
		}
		
		return ord.get().getOrderid();
		
	}
}
