package com.MyCompany.rest.exceptions;

import java.util.Date;

public class CustomErrorDetails {
	
	private Date timestamp;
	private String message;
	private String errordetails;
	
	// Field constructor
	
	public CustomErrorDetails(Date timestamp,String message, String errordetails)
	{
		this.timestamp=timestamp;
		this.message=message;
		this.errordetails=errordetails;
	}

	
	//getters.
	
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getErrordetails() {
		return errordetails;
	}
	

	
	
	
	

}
