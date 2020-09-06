package com.MyCompany.rest.dtos;

import java.util.List;

import com.MyCompany.rest.entities.Order;

public class UserDtoV2 {

	private long id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String role;
    private String ssn;
	private List<Order> orders;
	
	private String address;
	
	
	public UserDtoV2()
	{
		
	}
	
	public UserDtoV2(long id,String username, String firstname, String lastname, String email, String role, String ssn, String address)
	{
		this.id=id;
		this.username=username;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.role=role;
		this.ssn=ssn;
		this.address=address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
