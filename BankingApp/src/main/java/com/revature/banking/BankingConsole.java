package com.revature.banking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BankingConsole 
{
	public static ArrayList<UserAccount> allAccounts = new ArrayList<UserAccount>();
	public static ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	public static ArrayList<BankAccount> unapprovedAccounts = new ArrayList<BankAccount>();
	
	public static void main(String[] args) 
	{
		File bankAccountFile = new File("BankAccounts.txt"); 
		File customerFile = new File("Customers.txt");
		File employeeFile = new File("Employees.txt");
		File adminFile = new File("Admins.txt");
		File unapprovedFile = new File("UnapprovedAccounts.txt"); 
		
		/*Customer c = new Customer("John name", "jName", "qwerty", "1");
		ArrayList<Customer> cList = new ArrayList<Customer>();
		cList.add(c);
		allAccounts.add(c);
		allAccounts.add(new Employee("John nombre", "jName", "qwerty",cList));
		writeFile(customerFile);
		writeFile(employeeFile);*/
		
		readFile(customerFile);
		readFile(employeeFile);
		printArray(allAccounts);
		/*try 
		{
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) 
			{
				//String[] input = reader.nextLine().split(",");
				switch()
				{
					case "C":
						//allAccounts.add(new Customer(input[1], input[2], input[3], ));
						break;
					case "E":
						break;
					case "B":
						break;
					default:
						break;
						
				}
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}8?
		Scanner s = new Scanner(System.in);
		s.close();
		/*String input;
		char answer = 'n';
		while(answer != 'y')
		{
			run();
			System.out.print("Do you wish to quit?(Y/N): ");
			input = s.next().toLowerCase();
			answer = input.charAt(0);
		}
		s.close();*/
	}
	
	/*public static void prompt(String text)
	{
		System.out.print(text+": ");
	}
	
	public static void promptChoose(String text)
	{
		System.out.print(text+": ");
	}*/
	
	@SuppressWarnings("unchecked")
	public static void readFile(File f)
	{
		try 
		{
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(f));
			if(f.getName().contains("Customers"))
			{
				ArrayList<Customer> customers = (ArrayList<Customer>)objectIn.readObject();
				allAccounts.addAll(customers);
			}
			else if(f.getName().contains("Employees"))
			{
				ArrayList<Employee> employees = (ArrayList<Employee>)objectIn.readObject();
				allAccounts.addAll(employees);
			}
			else if(f.getName().contains("Admins"))
			{
				ArrayList<Admin> admins = (ArrayList<Admin>)objectIn.readObject();
				allAccounts.addAll(admins);
			}
			else if(f.getName().contains("BankAccounts"))
			{
				ArrayList<BankAccount> bankAccountList = (ArrayList<BankAccount>)objectIn.readObject();
				bankAccounts.addAll(bankAccountList);
			}
			else if(f.getName().contains("UnapprovedAccounts"))
			{
				ArrayList<BankAccount> unapprovedAccountList = (ArrayList<BankAccount>)objectIn.readObject();
				unapprovedAccounts.addAll(unapprovedAccountList);
			}
			objectIn.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("unchecked")
	public static void writeFile(File f)
	{
		try 
		{
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(f));
			if(f.getName().contains("Customers"))
			{
				ArrayList<Customer> customers = (ArrayList<Customer>)returnList("Customer");
				//printArray(customers);
				objectOut.writeObject(customers);
				//allAccounts.addAll(customers);
			}
			else if(f.getName().contains("Employees"))
			{
				ArrayList<Employee> employees = (ArrayList<Employee>)returnList("Employee");
				objectOut.writeObject(employees);
				//allAccounts.addAll(employees);
			}
			else if(f.getName().contains("Admins"))
			{
				ArrayList<Admin> customers = (ArrayList<Admin>)returnList("Admin");
				objectOut.writeObject(customers);
				//allAccounts.addAll(admins);
			}
			else if(f.getName().contains("BankAccounts"))
			{
				//ArrayList<BankAccount> customers = returnCustomer();
				objectOut.writeObject(bankAccounts);
				//bankAccounts.addAll(bankAccountList);
			}
			else if(f.getName().contains("UnapprovedAccounts"))
			{
				objectOut.writeObject(unapprovedAccounts);
				//unapprovedAccounts.addAll(unapprovedAccountList);
			}
			objectOut.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static ArrayList<?> returnList(String type)
	{
		switch(type)
		{
			case "Customer":
				ArrayList<Customer> cList = new ArrayList<Customer>();
				for(int i = 0; i < allAccounts.size(); i++)
				{
					if(allAccounts.get(i) instanceof Customer)
					{
						cList.add((Customer)allAccounts.get(i));
					}
				}
				return cList;
			case "Employee":
				ArrayList<Employee> eList = new ArrayList<Employee>();
				for(int i = 0; i < allAccounts.size(); i++)
				{
					if(allAccounts.get(i) instanceof Employee)
					{
						eList.add((Employee)allAccounts.get(i));
					}
				}
				return eList;
			case "Admin":
				ArrayList<Admin> aList = new ArrayList<Admin>();
				for(int i = 0; i < allAccounts.size(); i++)
				{
					if(allAccounts.get(i) instanceof Admin)
					{
						aList.add((Admin)allAccounts.get(i));
					}
				}
				return aList;
			default:
				break;
		}
		return null;
	}
	
	public static int printChoicePrompt(Prompt p)
	{
		System.out.print(p.getHeader()+"\n");
		Scanner s = new Scanner(System.in);
		HashMap<Integer, String> h = p.getChoices();
		if(!p.getChoices().isEmpty())
		{
			for(int i = 0; i < h.size(); i++)
			{
				System.out.print("\t"+(i+1)+" "+h.get(i+1)+ "\n");
			}
		}
		System.out.print(p.getInputPrompt());
		if(s.hasNextInt())
		{
			int choice = s.nextInt();
			//s.close();
			return choice;
		}
		s.close();
		return 0;
	}
	
	public static void run()
	{
		//PromptCollection promptList = new PromptCollection();
		//promptList.initialize();
		//int mainMenuChoice = printChoicePrompt(promptList.test);
		Scanner s = new Scanner(System.in);
		int mainMenuChoice = s.nextInt();
		s.close();
		switch(mainMenuChoice)
		{
			case 1:
				System.out.println("Login Sequence begin");
				login();
				break;
			case 2:
				System.out.println("Account creation sequence begin");
				createUserAccount();
				break;
			case 3:
				break;
			default:
				System.out.println("That is not a valid input. ");
				break;
		}
		
	}
	
	public static void login()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String userNameInput = s.nextLine();
		System.out.print("Enter your password: ");
		String passwordInput = s.nextLine();
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(userNameInput.equals(allAccounts.get(i).getUserName()) && passwordInput.equals(allAccounts.get(i).getPassword()))
			{
				
			}
		}
		
	}
	
	public static void createUserAccount()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Select what type of account you would like to create: \n\t1. Customer\n\t2. Employee\n\t");
		int input = s.nextInt();
		System.out.print("Enter your full name: ");
		String nameInput = s.nextLine();
		System.out.print("Enter your username: ");
		String userNameInput = s.nextLine();
		System.out.print("Enter your password: ");
		String passwordInput = s.nextLine();
		switch(input)
		{
			case 1:
				Customer c = new Customer(nameInput, userNameInput, passwordInput);
				s.close();
				break;
			case 2:
				System.out.print("Enter your employee ID number: ");
				String empIDInput = s.nextLine();
				s.close();
				break;
		}
		
		
	}
	
	public static void mainCustomerMenu(Customer c)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome back, "+c.getPersonName()+"! What would you like to do?: \n\t1. Apply for a new Account\n\t2. \n\t");
		int input = s.nextInt();
	}
	
	public static void printArray(ArrayList<?> array)
	{
		if(array.isEmpty())
		{
			System.out.print("Empty ArrayList");
		}
		for(int i = 0; i < array.size(); i++)
		{
			if(i == array.size()-1)
			{
				System.out.print(array.get(i) + "\n");
			}
			else
			{
				System.out.print(array.get(i)+", ");
			}
		}
	}
}
