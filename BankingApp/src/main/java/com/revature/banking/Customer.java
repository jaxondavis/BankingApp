package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends UserAccount implements Serializable
{
	private static final long serialVersionUID = -11996955294288750L;
	private ArrayList<String> accountIDs = new ArrayList<String>();
	
	public Customer()
	{
		
	}
	
	public Customer(String personName, String userName, String password)
	{
		this.personName = personName;
		this.userName = userName;
		this.password = password;
	}
	
	public Customer(String personName, String userName, String password, ArrayList<String> accountIDs)
	{
		this.personName = personName;
		this.userName = userName;
		this.password = password;
		this.accountIDs = accountIDs;
	}

	public ArrayList<String> getAccountIDs() 
	{
		return accountIDs;
	}

	public void setAccountIDs(ArrayList<String> accountIDs) 
	{
		this.accountIDs = accountIDs;
	}

	@Override
	public String toString() {
		return "Customer [personName=" + personName + ", userName=" + userName
				+ ", password=" + password + ", accountIDs= " + accountIDs + "]";
	}	
}
