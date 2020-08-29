package com.MyCompany.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyCompany.rest.entities.Order;
import com.MyCompany.rest.entities.User;
import com.MyCompany.rest.exceptions.UserNotFoundException;
import com.MyCompany.rest.repositories.OrderRepository;
import com.MyCompany.rest.repositories.UserRepository;

@RestController
@RequestMapping("/hateoas/users")
public class OrderHateoasController {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	/* getAllorders method add here*/
	
	@GetMapping("/{userid}/orders")
	public CollectionModel<Order> getAllOrders(@PathVariable("userid") Long userid) throws UserNotFoundException
	{
     		
		Optional<User> user=userRepository.findById(userid);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("User is not there is the respository");
		}
		
		//return user.get().getOrders();
		
		List<Order> allorders=user.get().getOrders();
		CollectionModel<Order> fin=new CollectionModel<Order>(allorders);
		
		return fin;
	}
	
	
}
