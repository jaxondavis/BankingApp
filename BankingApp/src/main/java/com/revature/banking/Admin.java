package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public final class Admin extends Employee implements Serializable
{
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String personName, String userName, String password, String employeeID,
			ArrayList<Customer> customers) {
		super(personName, userName, password, employeeID, customers);
		// TODO Auto-generated constructor stub
	}

	public Admin(String personName, String userName, String password, String employeeID) {
		super(personName, userName, password, employeeID);
		// TODO Auto-generated constructor stub
	}

	public Admin(String personName, String userName, String password) {
		super(personName, userName, password);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
