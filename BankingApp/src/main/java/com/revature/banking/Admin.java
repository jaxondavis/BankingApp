package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public final class Admin extends Employee implements Serializable
{
	private static final long serialVersionUID = 8117653648675318681L;
	
	public Admin() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String personName, String userName, String password, String employeeID)
	{
		this.personName = personName;
		this.userName = userName;
		this.password = password;
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "Admin [personName=" + personName + ", userName=" + userName
				+ ", password=" + password + "]";
	}
}
