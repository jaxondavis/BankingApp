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
	
	public Employee(String personName, String userName, String password) 
	{
		super();
		this.personName = personName;
		this.userName = userName;
		this.password = password;
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

	public ArrayList<Customer> getCustomers() 
	{
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) 
	{
		this.customers = customers;
	}
	
	public String getEmployeeID()
	{
		return employeeID;
	}

	public void setEmployeeID(String employeeID) 
	{
		this.employeeID = employeeID;
	}
	
	public boolean isCustomerInList(Customer input)
	{
		for(Customer c : customers)
		{
			if(c.equals(input))
			{
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<BankAccount> getUnapprovedAccounts(Customer c, ArrayList<BankAccount> unList)
	{
		ArrayList<BankAccount> list = new ArrayList<BankAccount>();
		for(String str : c.getAccountIDs())
		{
			for(int i = 0; i < unList.size(); i++)
			{
				if(unList.get(i).getAccountID().equals(str))
				{
					list.add(unList.get(i));
				}
			}
		}
		return list;
	}

	@Override
	public String toString() {
		return "Employee [personName=" + personName + ", userName=" + userName
				+ ", password=" + password + ", employeeID= " + employeeID + ", customers= "+customers+"]";
	}
}
