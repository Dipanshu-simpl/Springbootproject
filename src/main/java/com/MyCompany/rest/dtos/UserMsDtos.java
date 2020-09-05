package com.MyCompany.rest.dtos;

public class UserMsDtos {
	
	private long id;
	private String username;
	
	private String emailaddress;
	
	private String rolename;
	
	public UserMsDtos()
	{
		
	}
	
	public UserMsDtos(long id, String username, String emailaddress,String rolename)
	{
		this.id=id;
		this.username=username;
		this.emailaddress=emailaddress;
		this.rolename=rolename;
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

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	
	public String getRolename()
	{
		return rolename;
	}
	
	public void setRolename(String rolename)
	{
		this.rolename=rolename;
	}
}
