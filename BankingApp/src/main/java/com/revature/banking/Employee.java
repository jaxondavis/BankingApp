package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Employee extends UserAccount implements Serializable {
	private static final long serialVersionUID = -1780676410242272951L;
	private ArrayList<Customer> customerList;

	public Employee() {
		super();
	}

	public Employee(String personName, String userName, String password, ArrayList<Customer> customers) {
		super();
		this.personName = personName;
		this.userName = userName;
		this.password = password;
		this.customerList = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customerList;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customerList = customers;
	}

	// check if customer is in list
	public static boolean isCustomerInList(Customer cust, ArrayList<Customer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (cust.equals(list.get(i))) {
				return true;
			}
		}
		return false;

	}

	// view customer info
	public static void viewCustomerInfo(Customer cust, ArrayList<Customer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (cust.equals(list.get(i))) {
				System.out.println("Customer Name: " + cust.personName);
				System.out.println("Customer Username: " + cust.userName);
				System.out.println("Customer Password: " + cust.password);
			}
		}

		System.out.println();

	}

	//approve customer accounts
	//adding customer from unapproved account to approved account
	//adding id from unapproved account to approved customer
	public static void approveAccounts(Customer cust, ArrayList<BankAccount> approvedAcct, BankAccount unapprovedAcct) 
		{	
			approvedAcct.add(unapprovedAcct);
			cust.getAccountIDs().add(unapprovedAcct.getAccountID());
		}

		
	

	

}
	


