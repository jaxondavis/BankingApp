package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends UserAccount implements Serializable
{
	private static final long serialVersionUID = -1780676410242272951L;
	private ArrayList<Customer> customers;
	protected String employeeID;
	
	public Employee() 
	{
		super();
	}
	
	public Employee(String personName, String userName, String password, String employeeID) 
	{
		super();
		this.personName = personName;
		this.userName = userName;
		this.password = password;
		this.employeeID = employeeID;
	}

	public Employee(String personName, String userName, String password, String employeeID, ArrayList<Customer> customers) 
	{
		super();
		this.personName = personName;
		this.userName = userName;
		this.password = password;
		this.employeeID = employeeID;
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "Employee [personName=" + personName + ", userName=" + userName
				+ ", password=" + password + ", customers= " + customers + "]";
	}
}
