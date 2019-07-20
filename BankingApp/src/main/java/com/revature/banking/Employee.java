package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends UserAccount implements Serializable
{
	private static final long serialVersionUID = -1780676410242272951L;
	private ArrayList<Customer> customers;
	
	public Employee() 
	{
		super();
	}

	public Employee(String personName, String userName, String password, ArrayList<Customer> customers) 
	{
		super();
		this.personName = personName;
		this.userName = userName;
		this.password = password;
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	
}
