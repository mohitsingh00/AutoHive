package com.model;

import java.util.Scanner;
import com.controller.AddNewAccount;

public class Admin extends User {
	
	private Operation[] operations = new Operation[] {new AddNewAccount(1)};
	public Admin() {
		super();
	} 

	@Override
	public void showList(Database database, Scanner sc)
	{
		System.out.println("\n1. Add New Car");
		System.out.println("2. View Cars");
		System.out.println("3. Update Car");
		System.out.println("4. Delete Car");
		System.out.println("5. Add New Admin");
		System.out.println("6. Show Rents");
		System.out.println("7. Quit\n");
		
		int i = sc.nextInt();
		operations[0].operation(database, sc, this);
	}
}
