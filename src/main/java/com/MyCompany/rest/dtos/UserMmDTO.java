package com.MyCompany.rest.dtos;

import java.util.List;

import com.MyCompany.rest.entities.Order;

public class UserMmDTO {
	
	
	private long id;
	private String username;
	private String firstname;
	private List<Order> orders;
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id=id;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname=firstname;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	

}
