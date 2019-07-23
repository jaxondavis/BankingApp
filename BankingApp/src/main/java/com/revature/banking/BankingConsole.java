package com.revature.banking;

import static org.hamcrest.CoreMatchers.containsString;

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
	public static File bankAccountFile = new File("BankAccounts.txt"); 
	public static File customerFile = new File("Customers.txt");
	public static File employeeFile = new File("Employees.txt");
	public static File adminFile = new File("Admins.txt");
	public static File unapprovedFile = new File("UnapprovedAccounts.txt");
	public static UserAccount loggedInAccount;

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		readFile(bankAccountFile);
		readFile(customerFile);
		readFile(employeeFile);
		readFile(adminFile);
		printArray(allAccounts);
		//printArray(bankAccounts);
		
		String input = "n";
		do
		{
			run();
			System.out.print("Do you wish to quit?(Y/N): ");
			input = s.next().toLowerCase();
			//s.close();
		}while(input.equals("n"));
		
	}
	
	public static void initializeValues()
	{
		/*BankAccount b1 = new BankAccount(1254.9, "id27451", "Checking", false);
		BankAccount b2 = new BankAccount(98.0, "id84633", "Savings", true);
		ArrayList<String> testIDs = new ArrayList<String>();
		bankAccounts.add(b1);
		bankAccounts.add(b2);
		testIDs.add(b1.getAccountID());
		testIDs.add(b2.getAccountID());
		Customer c = new Customer("John name", "jName", "qwerty", testIDs);
		ArrayList<Customer> cList = new ArrayList<Customer>();
		cList.add(c);
		allAccounts.add(c);
		allAccounts.add(new Employee("John nombre", "nombre1", "qwerty", "emp321",cList));
		writeFile(customerFile);
		writeFile(employeeFile);
		Admin a = new Admin("John Madden", "jMadden03", "football", "admin123");
		allAccounts.add(a);
		writeFile(adminFile);
		//customerAccounts.add(c);
		writeFile(bankAccountFile);*/
	}
	
	@SuppressWarnings("unchecked")
	public static void readFile(File f)
	{
		try 
		{
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(f));
			//customerAccounts.addAll((ArrayList<Customer>)objectIn.readObject());
			if(f.getName().contains("UserAccounts"))
			{
				allAccounts.addAll((ArrayList<UserAccount>)objectIn.readObject());
			}
			else if(f.getName().contains("Customers"))
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
			else if(f.getName().contains("UnapprovedAccounts"))
			{
				//ArrayList<BankAccount> unapprovedAccountList = (ArrayList<BankAccount>)objectIn.readObject();
				//unapprovedAccounts.addAll(unapprovedAccountList);
				unapprovedAccounts.addAll((ArrayList<BankAccount>)objectIn.readObject());
			}
			else if(f.getName().contains("BankAccounts"))
			{
				//ArrayList<BankAccount> bankAccountList = (ArrayList<BankAccount>)objectIn.readObject();
				//bankAccounts.addAll(bankAccountList);
				bankAccounts.addAll((ArrayList<BankAccount>)objectIn.readObject());
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
			if(f.getName().contains("UserAccounts"))
			{
				objectOut.writeObject(allAccounts);
			}
			else if(f.getName().contains("Customers"))
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
			
			else if(f.getName().contains("UnapprovedAccounts"))
			{
				objectOut.writeObject(unapprovedAccounts);
			}
			else if(f.getName().contains("BankAccounts"))
			{
				objectOut.writeObject(bankAccounts);
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
		
		Scanner s = new Scanner(System.in);
		boolean q = false;
		do
		{
			System.out.println("Welcome!\n\t1. Login\n\t2. Create Account\n\t3. Quit");
			int mainMenuChoice = s.nextInt();
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
					q = true;
					break;
				default:
					System.out.println("That is not a valid input. ");
					break;
			}
		}while(q == false);
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
				if(allAccounts.get(i) instanceof Customer)
				{
					mainCustomerMenu((Customer)loggedInAccount);
				}
				else if(allAccounts.get(i) instanceof Employee)
				{
					mainEmployeeMenu((Employee)loggedInAccount);
				}
				else if(allAccounts.get(i) instanceof Admin)
				{
					mainAdminMenu((Admin)loggedInAccount);
				}
				
			}
		}
		//s.close();
		
		//mainCustomerMenu(loggedInAccount);
	}
	
	public static void createUserAccount()
	{
		Scanner s = new Scanner(System.in);
		//UserAccount.AccountType type = UserAccount.AccountType.Customer;
		String nameInput = "", userNameInput = "", passwordInput = "";
		System.out.println("Select what type of account you would like to create: \n\t1. Customer\n\t2. Employee\n\t3. Admin");
		int input = s.nextInt();
		s.nextLine();
		System.out.println("Enter your full name: ");
		nameInput = s.nextLine();
		System.out.println("Input: "+nameInput);
		System.out.print("Enter your username: ");
		if(s.hasNext())
		{
			userNameInput = s.next();
		}
		System.out.print("Enter your password: ");
		if(s.hasNext())
		{
			passwordInput = s.next();
		}
		
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(userNameInput.equals(allAccounts.get(i).getUserName()))
			{
				
				if(passwordInput.equals(allAccounts.get(i).getPassword()))
				{
					System.out.println("That password already exists");
					break;
				}
				System.out.println("That username already exists");
				break;
			}
			else
			{
				switch(input)
				{
					case 1:
						Customer custAccount = new Customer(nameInput, userNameInput, passwordInput);
						allAccounts.add(custAccount);
						mainCustomerMenu(custAccount);
						break;
					case 2:
						Employee empAccount = new Employee(nameInput, userNameInput, passwordInput);
						allAccounts.add(empAccount);
						break;
					case 3:
						Admin adminAccount = new Admin(nameInput, userNameInput, passwordInput);
						allAccounts.add(adminAccount);
						break;
				}	
			}
			
		}
	}
	public static void mainCustomerMenu(Customer account)
	{
		Scanner s = new Scanner(System.in);
		boolean q = false;
		do
		{
			System.out.println("\nWelcome back, "+account.getPersonName()+"! What would you like to do? \n\t1. View Current Accounts\n\t2. Apply for a new Account\n\t3. Deposit Funds\n\t4. Withdraw Funds\n\t5. Transfer Funds\n\t6. Logout");
			System.out.print("Enter your input: ");
			int input = s.nextInt();
			s.nextLine();
			switch(input)
			{
				case 1:
					printAccounts((Customer)loggedInAccount);
					break;
				case 2:
					applyForAccount();
					break;
				case 3:
					System.out.println("Choose an account:");
					BankAccount b1 = promptAccount((Customer)loggedInAccount);
					b1.deposit();
					break;
				case 4:
					System.out.println("Choose an account:");
					BankAccount b2 = promptAccount((Customer)loggedInAccount);
					b2.withdraw();
					break;
				case 5:
					System.out.println("Choose an account to transfer funds from:");
					BankAccount b3 = promptAccount((Customer)loggedInAccount);
					System.out.println("Choose an account to transfer funds to:");
					BankAccount b4 = promptAccount((Customer)loggedInAccount);
					b3.transfer(b4);
					break;
				case 6:
					q = true;
					break;
			}
		}while(q == false);
	}
	
	public static void applyForAccount()
	{
		Scanner s = new Scanner(System.in);
		BankAccount b = null;
		String name = "";
		String id = "";
		System.out.println("What kind of account will this be?:\n\t1. New Account\n\t2. Joint Account");
		int choice = s.nextInt();
		s.nextLine();
		switch(choice)
		{
			case 1:
				System.out.print("Enter the name of the account: ");
				name = s.nextLine();
				id = BankAccount.generateAccountID();
				break;
			case 2:
				System.out.print("Enter the name of the account you wish to add: ");
				name = s.nextLine();
				System.out.print("Enter the id of the account you wish to add: ");
				id = s.nextLine();
				break;
		}
		
		b = new BankAccount(0.0, id, name, false);
		unapprovedAccounts.add(b);
	}
	
	public static void mainEmployeeMenu(Employee account)
	{
		Scanner s = new Scanner(System.in);
		boolean q = false;
		do
		{
			System.out.println("\nWelcome back, "+account.getPersonName()+"! What would you like to do? \n\t1. View Customer Information\n\t2. View Current Applications\n\t3. Quit");			
			System.out.print("Enter your input: ");
			int input = s.nextInt();
			s.nextLine();
			switch(input)
			{
				case 1:
					for(Customer c : account.getCustomers())
					{
						System.out.println(c.getPersonName()+"\n");
						printAccounts(c);
						System.out.println();
					}
					break;
				case 2:
					
					break;
				case 3:
					q = true;
					break;
			}
		}while(q == false);
	}
	
	public static void mainAdminMenu(Admin account)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("\nWelcome back, "+account.getPersonName()+"! What would you like to do? \n\t1. View Customer Information\n\t2. View Current Applications\n\t");
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
	
	public static BankAccount promptAccount(Customer c)
	{
		//System.out.println("Choose an account: ");
		Scanner s1 = new Scanner(System.in);
		printAccounts(c);
		System.out.print("Enter the accountID: ");
		String input = s1.next();
		BankAccount b = returnAccount(c, input);
		return b;
	}

	public static void printAccounts(Customer c)
	{
		for(String str : c.getAccountIDs())
		{
			for(int i = 0; i < bankAccounts.size(); i++)
			{
				if(bankAccounts.get(i).getAccountID().equals(str))
				{
					System.out.println(bankAccounts.get(i).getName()+"\n ID: "+bankAccounts.get(i).getAccountID()+"\n Balance: $"+bankAccounts.get(i).getAmount());
				}
			}
		}
	}

	public static BankAccount returnAccount(Customer c, String s)
	{
		for(int i = 0; i < bankAccounts.size(); i++)
		{
			if(bankAccounts.get(i).getAccountID().equals(s))
			{
				return bankAccounts.get(i);
			}
		}
		return null;
	}
}
