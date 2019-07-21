package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends UserAccount implements Serializable
{
	private static final long serialVersionUID = -11996955294288750L;
	private ArrayList<String> accountIDs;
	
	public Customer(String personName, String userName, String password, String ... accountIDs)
	{
		this.personName = personName;
		this.userName = userName;
		this.password = password;
		for(String s : accountIDs)
		{
			this.accountIDs.add(s);
		}
	}

	public ArrayList<String> getAccountIDs() {
		return accountIDs;
	}

	public void setAccountIDs(ArrayList<String> accountIDs) {
		this.accountIDs = accountIDs;
	}

	@Override
	public String toString() {
		return "Customer [personName=" + personName + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
}
