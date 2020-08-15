package com.MyCompany.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyCompany.rest.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	// GetUser By Username
	
	User findByUsername(String username);

}
