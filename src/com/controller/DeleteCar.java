package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.model.Database;
import com.model.Operation;
import com.model.User;

public class DeleteCar implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println("Enter ID: (-1 to show all cars)");
		int ID = sc.nextInt();
		while(ID == -1)
		{
			new ViewCars().operation(database, sc, user);
			System.out.println("Enter ID: (-1 to show all cars)");
			ID = sc.nextInt();
		}
		
		try
		{
			String update = "UPDATE `cars` SET `Available` = '2' WHERE `ID` = '"+ID+"';";
			database.getStatement().execute(update);
			System.out.println("Car Deleted Successfully");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	
}
