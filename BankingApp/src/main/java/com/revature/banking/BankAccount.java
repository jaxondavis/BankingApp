package com.revature.banking;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Random;

public class BankAccount implements Serializable
{

	private static final long serialVersionUID = 6185608016529091662L;

	private double balance;
	private String accountID;
	private String name;
	private boolean approved;
	
	public BankAccount()
	{
		
	}
	
	public BankAccount(double balance, String accountID, String name) 
	{
		super();
		this.balance = balance;
		this.accountID = accountID;
		this.name = name;
	}
	
	public BankAccount(double balance, String accountID, String name, boolean approved) 
	{
		super();
		this.balance = balance;
		this.accountID = accountID;
		this.name = name;
		this.approved = approved;
	}

	public double getAmount() 
	{
		return balance;
	}

	public void setAmount(double balance) 
	{
		this.balance = balance;
	}
	
	public void withdraw()
	{
		double amount = 0;
		System.out.print("Enter the amount to withdraw: $");
		Scanner s = new Scanner(System.in);
		amount = s.nextDouble();
		s.nextLine();
		if(amount <= 0)
		{
			System.out.println("Underdraft Error: That withdraw amount is too little(less than 1)");
		}
		else if(amount > this.getAmount())
		{
			System.out.println("Overdraft Error: That withdraw amount is too much(greater than account balance)");
		}
		else
		{
			this.balance -= amount;
			System.out.println("New Balance after transaction: $"+this.balance);
		}
	}
	
	public void deposit()
	{
		double amount = 0;
		System.out.print("Enter the amount to deposit: $");
		Scanner s = new Scanner(System.in);
		amount = s.nextDouble();
		s.nextLine();
		if(amount <= 0)
		{
			System.out.println("Underdraft Error: That deposit amount is too little(less than 1)");
		}
		else
		{
			this.balance += amount;
			System.out.println("New Balance after transaction: $"+this.balance);
		}
	}
	
	public void transfer(BankAccount transferTo)
	{
		double amount = 0;
		System.out.print("Enter the amount to transfer from "+this.getName()+" to "+transferTo.getName()+": $");
		Scanner s = new Scanner(System.in);
		amount = s.nextDouble();
		s.nextLine();
		if(amount <= 0)
		{
			System.out.println("Underdraft Error: That transfer amount is little(less than 1)");
		}
		else if(amount >= this.getAmount())
		{
			System.out.println("Overdraft Error: That deposit amount is too much(greater than account balance)");
		}
		else
		{
			this.balance -= amount;
			transferTo.setAmount(transferTo.getAmount()+amount);
			System.out.println("New "+transferTo.getName()+" Balance after transaction: $"+transferTo.getAmount());
			System.out.println("New "+this.getName()+" Balance after transaction: $"+this.balance);
		}
	}

	public String getAccountID() 
	{
		return accountID;
	}

	public void setAccountID(String accountID) 
	{
		this.accountID = accountID;
	}
	
	public static String generateAccountID()
	{
		Random r = new Random();
		char[] charList = new char[5];
		for(int i = 0; i < 4; i++)
		{
			charList[i] = (char)(r.nextInt(9)+48);
		}
		String result = new String(charList);
		result = "id"+result;
		return result;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public boolean isApproved() 
	{
		return approved;
	}

	public void setApproved(boolean approved) 
	{
		this.approved = approved;
	}
	
	public String toString()
	{
		return "Account Name: "+name+", AccountID: "+accountID+", Balance: "+balance+", Approved?: "+approved;
	}
}
