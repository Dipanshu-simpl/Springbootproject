package com.MyCompany.rest.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	
	// Writing one simple method
	//@RequestMapping(method=RequestMethod.GET,path="/helloworld")
	// using @GetMapping annotation.
	@GetMapping("/hello")
	public String helloWorld()
	{
		return "Welcome to Spring boot Rest Project";
	}
	
	
	@GetMapping("/hellobean")
	public UserDetails getdetails()
	{
		return new UserDetails("Dipanshu","Magoo","232332");
	}
}
