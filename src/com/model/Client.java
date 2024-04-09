package com.model;

import java.util.Scanner;

import com.controller.ViewCars;

public class Client extends User {

	private Operation[] operations = new Operation[] {new ViewCars()};
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
		System.out.println("5. Edit My Data");
		System.out.println("6. Quit\n");
		
	}
	
	
	
}
