package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public final class Admin extends Employee implements Serializable
{
	private static final long serialVersionUID = 8117653648675318681L;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String personName, String userName, String password, ArrayList<Customer> customers) {
		super(personName, userName, password, customers);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [personName=" + personName + ", userName=" + userName + ", password=" + password
				+ ", getCustomers()=" + getCustomers() + ", getPersonName()=" + getPersonName() + ", getUserName()="
				+ getUserName() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public ArrayList<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return super.getCustomers();
	}

	@Override
	public void setCustomers(ArrayList<Customer> customers) {
		// TODO Auto-generated method stub
		super.setCustomers(customers);
	}

	@Override
	public String getPersonName() {
		// TODO Auto-generated method stub
		return super.getPersonName();
	}

	@Override
	public void setPersonName(String personName) {
		// TODO Auto-generated method stub
		super.setPersonName(personName);
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		super.setUserName(userName);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}
	
	
	
	public Admin() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String personName, String userName, String password)
	{
		this.personName = personName;
		this.userName = userName;
		this.password = password;
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
