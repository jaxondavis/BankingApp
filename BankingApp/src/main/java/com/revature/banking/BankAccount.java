package com.revature.banking;

import java.io.Serializable;

public class BankAccount implements Serializable
{

	private static final long serialVersionUID = 6185608016529091662L;

	private double amount;
	private String accountID;
	private String name;
	
	public BankAccount()
	{
		
	}
	
	
	public BankAccount(double amount, String accountID, String name) 
	{
		super();
		this.amount = amount;
		this.accountID = accountID;
		this.name = name;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	public String getAccountID() 
	{
		return accountID;
	}

	public void setAccountID(String accountID) 
	{
		this.accountID = accountID;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
}
