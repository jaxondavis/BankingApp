package com.revature.banking;

import java.io.Serializable;

public abstract class UserAccount implements Serializable
{
	private static final long serialVersionUID = -3450814398265583147L;
	protected String personName, userName, password;

	public String getPersonName() 
	{
		return personName;
	}

	public void setPersonName(String personName) 
	{
		this.personName = personName;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
}
