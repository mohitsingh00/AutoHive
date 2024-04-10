package com.model;

import java.util.Scanner;

import com.controller.ChangePassword;
import com.controller.EditUserData;
import com.controller.Quit;
import com.controller.RentCar;
import com.controller.ReturnCar;
import com.controller.ShowUserRents;
import com.controller.ViewCars;

public class Client extends User {

	private Operation[] operations = new Operation[] {new ViewCars(), new RentCar(), 
			new ReturnCar(), new ShowUserRents(2), new EditUserData(), new ChangePassword(), new Quit()};
	public Client() {
		super();
	}

	@Override
	public void showList(Database database, Scanner sc)
	{
		System.out.println("\n1. View Cars");
		System.out.println("2. Rent Car");
		System.out.println("3. Return Car");
		System.out.println("4. Show My Rents");
		System.out.println("5. Edit My Profile");
		System.out.println("6. Change Password");
		System.out.println("7. Quit\n");
		
		int i = sc.nextInt(); 
		if(i<1 || i>7)
		{
			System.out.println("Your Choose Invalid Option");
			System.out.println("Please, select the correct Option");
			showList(database, sc);
			
			return;
		}
		
		operations[i-1].operation(database, sc, this);
		if(i != 7) showList(database, sc);
	}
}
