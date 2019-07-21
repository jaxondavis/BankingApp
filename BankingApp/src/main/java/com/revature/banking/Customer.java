package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends UserAccount implements Serializable
{
	private static final long serialVersionUID = -11996955294288750L;
	private ArrayList<String> accountIDs = new ArrayList<String>();
	
	public Customer(String personName, String userName, String password, String ... accountIDArrays)
	{
		this.personName = personName;
		this.userName = userName;
		this.password = password;
		for(String s : accountIDArrays)
		{
			this.accountIDs.add(s);
		}
	}

	@Override
	public String toString() {
		return "Customer [accountIDs=" + accountIDs + ", personName=" + personName + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
	
}
