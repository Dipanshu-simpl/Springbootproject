package com.MyCompany.rest.Hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	
	
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
	
	@GetMapping("/hello-i18n")
	public String getMessageinternalization(@RequestHeader(name="Accept-Language" , required=false)String locale)
	{
  		return messageSource.getMessage("label.hello",null,new Locale(locale));
	}
	
}
