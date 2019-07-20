package com.revature.banking;

import java.util.ArrayList;

public class Employee extends UserAccount {
	ArrayList<Customer> customerList = new ArrayList<Customer>();

	public Employee() {

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

	public static void approveAccounts(ArrayList<Customer> list) {
		

	}
}
