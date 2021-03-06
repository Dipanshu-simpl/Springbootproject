package com.MyCompany.rest;



import java.util.Locale;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

// Adding a comment here
@SpringBootApplication
public class SpringbootapplicationrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapplicationrestApplication.class, args);
		
		
		
	}
	
	@Bean
	public AcceptHeaderLocaleResolver localeResolver()
	{
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	
	@Bean
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}

