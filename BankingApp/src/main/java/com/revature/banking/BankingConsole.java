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
	//public static ArrayList<Customer> customerAccounts = new ArrayList<Customer>();
	//public static ArrayList<Employee> employeeAccounts = new ArrayList<Employee>();
	//public static ArrayList<Admin> adminAccounts = new ArrayList<Admin>();
	public static ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	public static ArrayList<BankAccount> unapprovedAccounts = new ArrayList<BankAccount>();
	public static UserAccount loggedInAccount;

	public static void main(String[] args) 
	{
		File bankAccountFile = new File("BankAccounts.txt"); 
		File customerFile = new File("Customers.txt");
		File employeeFile = new File("Employees.txt");
		File adminFile = new File("Admins.txt");
		File unapprovedFile = new File("UnapprovedAccounts.txt"); 
		//ArrayList<String> testIDs = new ArrayList<String>();
		//testIDs.add("12");
		//Customer c = new Customer("John name", "jName", "qwerty", testIDs);
		//ArrayList<Customer> cList = new ArrayList<Customer>();
		//cList.add(c);
		//allAccounts.add(c);
		//customerAccounts.add(c);
		//allAccounts.add(new Employee("John nombre", "nombre1", "qwerty",cList));
		//writeFile(customerFile);
		//writeFile(employeeFile);
		
		readFile(customerFile);
		readFile(employeeFile);
		printArray(allAccounts);
		
		String input;
		do
		{
			run();
			Scanner s = new Scanner(System.in);
			System.out.print("Do you wish to quit?(Y/N): ");
			input = s.next().toLowerCase();
			//s.close();
		}while(input == "y");
		
	}
	
	@SuppressWarnings("unchecked")
	public static void readFile(File f)
	{
		try 
		{
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(f));
			
			//customerAccounts.addAll((ArrayList<Customer>)objectIn.readObject());
			if(f.getName().contains("Customers"))
			{
				allAccounts.addAll((ArrayList<Customer>)objectIn.readObject());
				//ArrayList<Customer> customers = (ArrayList<Customer>)objectIn.readObject();
				//System.out.println(customers.get(0));
				//customerAccounts.addAll(customers);
				//allAccounts.addAll(customers);
				//ArrayList<Customer> customers = returnCustList();
				//Customer c = (Customer) objectIn.readObject();
				//System.out.println(c.getPersonName());
				//allAccounts.add(c);
			}
			else if(f.getName().contains("Employees"))
			{
				//ArrayList<Employee> employees = (ArrayList<Employee>)objectIn.readObject();
				//allAccounts.addAll(employees);
				allAccounts.addAll((ArrayList<Employee>)objectIn.readObject());
			}
			else if(f.getName().contains("Admins"))
			{
				//ArrayList<Admin> admins = (ArrayList<Admin>)objectIn.readObject();
				//allAccounts.addAll(admins);
				allAccounts.addAll((ArrayList<Admin>)objectIn.readObject());
			}
			else if(f.getName().contains("BankAccounts"))
			{
				//ArrayList<BankAccount> bankAccountList = (ArrayList<BankAccount>)objectIn.readObject();
				//bankAccounts.addAll(bankAccountList);
				bankAccounts.addAll((ArrayList<BankAccount>)objectIn.readObject());
			}
			else if(f.getName().contains("UnapprovedAccounts"))
			{
				//ArrayList<BankAccount> unapprovedAccountList = (ArrayList<BankAccount>)objectIn.readObject();
				//unapprovedAccounts.addAll(unapprovedAccountList);
				unapprovedAccounts.addAll((ArrayList<BankAccount>)objectIn.readObject());
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
	
	public static void writeFile(File f)
	{
		
		try 
		{
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(f, false));
			//objectOut.writeObject(customerAccounts);
			if(f.getName().contains("Customers"))
			{
				ArrayList<Customer> customers = returnCustList();
				objectOut.writeObject(customers);
				//objectOut.writeObject(customerAccounts);
				//for(int i = 0; i < customers.size(); i++)
				//{
					//Customer c = customers.get(i);
					//System.out.println(c.getPersonName());
					//objectOut.writeObject(c);
					//objectOut.writeObject(c);
				//}
			}
			else if(f.getName().contains("Employees"))
			{
				ArrayList<Employee> employees = returnEmpList();
				objectOut.writeObject(employees);
			}
			else if(f.getName().contains("Admins"))
			{
				ArrayList<Admin> admins = returnAdList();
				objectOut.writeObject(admins);
			}
			else if(f.getName().contains("BankAccounts"))
			{
				objectOut.writeObject(bankAccounts);
			}
			else if(f.getName().contains("UnapprovedAccounts"))
			{
				objectOut.writeObject(unapprovedAccounts);
			}
			else
			{
				System.out.println("Not a valid file");
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
	
	public static ArrayList<Customer> returnCustList()
	{
		ArrayList<Customer> cList = new ArrayList<Customer>();
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(allAccounts.get(i) instanceof Customer)
			{
				cList.add((Customer)allAccounts.get(i));
			}
		}
		return cList;
	}
	
	public static ArrayList<Employee> returnEmpList()
	{
		ArrayList<Employee> eList = new ArrayList<Employee>();
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(allAccounts.get(i) instanceof Employee)
			{
				eList.add((Employee)allAccounts.get(i));
			}
		}
		return eList;
	}
	
	public static ArrayList<Admin> returnAdList()
	{
		ArrayList<Admin> aList = new ArrayList<Admin>();
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(allAccounts.get(i) instanceof Admin)
			{
				aList.add((Admin)allAccounts.get(i));
			}
		}
		return aList;
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
		//s.close();
		return 0;
	}
	
	public static void run()
	{
		//PromptCollection promptList = new PromptCollection();
		//promptList.initialize();
		//int mainMenuChoice = printChoicePrompt(promptList.test);
		System.out.println("Welcome!\n\t1. Login\n\t2. Create Account\n\t3. Quit");
		Scanner s = new Scanner(System.in);
		int mainMenuChoice = s.nextInt();
		//s.close();
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
		
		System.out.print("Enter your username: ");
		Scanner s = new Scanner(System.in);
		String userNameInput = s.nextLine();
		System.out.print("Enter your password: ");
		String passwordInput = s.nextLine();
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(userNameInput.equals(allAccounts.get(i).getUserName()) && passwordInput.equals(allAccounts.get(i).getPassword()))
			{
				loggedInAccount = allAccounts.get(i);
			}
		}
		//s.close();
		mainCustomerMenu((Customer)loggedInAccount);
	}
	
	public static void createUserAccount()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Select what type of account you would like to create: \n\t1. Customer\n\t2. Employee\n\t3. Admin");
		int input = s.nextInt();
		System.out.print("Enter your full name: ");
		String nameInput = s.nextLine();
		System.out.print("Enter your username: ");
		String userNameInput = s.nextLine();
		System.out.print("Enter your password: ");
		String passwordInput = s.nextLine();
		String empIDInput = null;
		switch(input)
		{
			case 1:
				ArrayList<Customer> customers = returnCustList();
				for(int i = 0; i < customers.size(); i++)
				{
					if(userNameInput.equals(customers.get(i).getUserName()))
					{
						if(passwordInput.equals(customers.get(i).getPassword()))
						{
							System.out.println("That password already exists");
							break;
						}
						System.out.println("That username already exists");
						break;
					}
					else
					{
						Customer c = new Customer(nameInput, userNameInput, passwordInput);
						allAccounts.add(c);
					}
				}
				//s.close();
				break;
			case 2:
				System.out.print("Enter your employee ID number: ");
				empIDInput = s.nextLine();
				ArrayList<Employee> employees = returnEmpList();
				for(int i = 0; i < employees.size(); i++)
				{
					if(empIDInput.equals(employees.get(i).getEmployeeID()))
					{
						if(userNameInput.equals(employees.get(i).getUserName()))
						{
							if(passwordInput.equals(employees.get(i).getPassword()))
							{
								System.out.println("That password already exists");
								break;
							}
							System.out.println("That username already exists");
							break;
						}
						System.out.println("That employee ID number already exists");
						break;
					}
					else
					{
						Employee e = new Employee(nameInput, userNameInput, passwordInput, empIDInput);
						allAccounts.add(e);
					}
				}
				break;
			case 3:
				System.out.print("Enter your employee ID number: ");
				empIDInput = s.nextLine();
				ArrayList<Admin> admins = returnAdList();
				for(int i = 0; i < admins.size(); i++)
				{
					if(empIDInput.equals(admins.get(i).getEmployeeID()))
					{
						if(userNameInput.equals(admins.get(i).getUserName()))
						{
							if(passwordInput.equals(admins.get(i).getPassword()))
							{
								System.out.println("That password already exists");
								break;
							}
							System.out.println("That username already exists");
							break;
						}
						System.out.println("That employee ID number already exists");
						break;
					}
					else
					{
						Admin a = new Admin(nameInput, userNameInput, passwordInput, empIDInput);
						allAccounts.add(a);
					}
				}
				//s.close();
				break;
			default:
				break;
		}
		
	}
	
	public static void mainCustomerMenu(Customer c)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("\nWelcome back, "+c.getPersonName()+"! What would you like to do? \n\t1. Apply for a new Account\n\t2. \n\t");
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
