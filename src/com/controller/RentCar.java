package com.controller;

import java.sql.ResultSet;
import java.util.Scanner;

import com.model.Car;
import com.model.Database;
import com.model.Operation;
import com.model.Rent;
import com.model.User;

public class RentCar implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println("Enter Car ID: (-1 to show all cars)");
		int CarID = sc.nextInt();
		while(CarID == -1)
		{
			new ViewCars().operation(database, sc, user);
			System.out.println("Enter Car ID: (-1 to show all cars)");
			CarID = sc.nextInt();
			
		}
		
		System.out.println("Enter hours: ");
		int hours = sc.nextInt();
		
		try
		{
			ResultSet rs0 = database.getStatement().executeQuery("SELECT * FROM `cars` WHERE `ID` = '"+CarID+"'");
			rs0.next();
			Car car = new Car();
			car.setID(rs0.getInt("ID"));
			car.setBrand(rs0.getString("Brand"));
			car.setModel(rs0.getString("Model"));
			car.setColor(rs0.getString("Color"));
			car.setYear(rs0.getInt("Year"));
			car.setPrice(rs0.getDouble("Price"));
			car.setAvailable(rs0.getInt("Available"));
			
			if(car.isAvailable() != 0)
			{
				System.out.println("Car isn't available");
				return;
			}
			
			double total = car.getPrice() * hours;
			Rent rent = new Rent();
			
			String insert = "INSERT INTO `rents`(`User`,`Car`,`DateTime`,`Hours`,`Total`,`Status`) VALUES"
					+ " ('"+user.getID()+"','"+car.getID()+"', '"+rent.getDateTime()+"', '"+hours+"', '"+total+"', '0'";
			
			database.getStatement().execute(insert);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
