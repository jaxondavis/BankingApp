package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

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
	public boolean isCustomerInList(Customer cust) {
		for (int i = 0; i < customerList.size(); i++) {
			if (cust.equals(customerList.get(i))) {
				return true;
			}
		}
		return false;
	}

	// view customer info
	public void viewCustomerInfo(Customer cust) {
		for (int i = 0; i < customerList.size(); i++) {
			if (cust.equals(customerList.get(i))) {
				System.out.println("Customer Name: " + cust.personName);
				System.out.println("Customer Username: " + cust.userName);
				System.out.println("Customer Password: " + cust.password);
			}
		}
	}

	public void approveAccounts(Customer cust, ArrayList<BankAccount> approvedAcct, BankAccount unapprovedAcct) {
		approvedAcct.add(unapprovedAcct);
		cust.getAccountIDs().add(unapprovedAcct.getAccountID());
	}

}
