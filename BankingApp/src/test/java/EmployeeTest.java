
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.banking.BankAccount;
import com.revature.banking.Customer;
import com.revature.banking.Employee;

class EmployeeTest {

	Employee e1 = new Employee();
	
	
	@Test
	void test() {
		
		Customer cust = new Customer();
		Customer cust2 = new Customer();
		cust.setPersonName("Bob");
		cust2.setPersonName("Robert");


		
		e1.getCustomers().add(cust);
		e1.getCustomers().add(cust2);
		
		
		assertEquals(true, e1.isCustomerInList(cust));
	
	}
	
	void test2() {
		ArrayList<BankAccount> unList = new ArrayList<BankAccount>();
		Customer cust3 = new Customer();
		BankAccount bank1 = new BankAccount();
		
		cust3.setPersonName("Steve");
		bank1.setName("Steve");
		unList.add(bank1);
		
		ArrayList<BankAccount> newList = new ArrayList<BankAccount>();
		
		
		
		assertEquals(newList,e1.getUnapprovedAccounts(cust3, unList));
			
			
		}
	}
	
	
	
	


