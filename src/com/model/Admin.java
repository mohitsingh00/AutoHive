package com.model;

import java.util.Scanner;
import com.controller.AddNewAccount;
import com.controller.AddNewCar;
import com.controller.DeleteCar;
import com.controller.UpdateCar;
import com.controller.ViewCars;

public class Admin extends User {
	
	private Operation[] operations = new Operation[] {new AddNewCar(), new ViewCars(), new UpdateCar(), new DeleteCar(), new AddNewAccount(1)};
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
	//	System.out.println("6. Show Rents");
	//	System.out.println("7. Show User's Rents");
		System.out.println("8. Edit My Profile");
		System.out.println("9. Change Password");
		System.out.println("10. Quit\n");
		
		int i = sc.nextInt();
		operations[i-1].operation(database, sc, this);
		showList(database,sc);
	}
}
