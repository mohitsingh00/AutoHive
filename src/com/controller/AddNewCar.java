package com.controller;

import java.lang.management.OperatingSystemMXBean;
import java.util.Scanner;

import com.model.Database;
import com.model.Operation;
import com.model.User;

public class AddNewCar implements Operation{

	@Override
	public void operation(Database database, Scanner sc, User user)
	{
		System.out.println("Enter Brand: ");
		String brand = sc.next();
		System.out.println("Enter Model: ");
		String model = sc.next();
		System.out.println("Enter Color: ");
		String color = sc.next();
		System.out.println("Enter Year: ");
		int year = sc.nextInt();
		System.out.println("Enter Price per hour: ");
		Double price = sc.nextDouble();
		int available = 0;
		
		try
		{
			String insert = "INSERT INTO `carrentalsystem`.`cars`(`Brand`,`Model`,`Color`,`Year`,`Price`,`Available`) "
					+ "VALUES('"+brand+"','"+model+"','"+color+"','"+year+"','"+price+"','"+available+"');";
			
			database.getStatement().execute(insert);
			System.out.println("Car Added Scuccessfully");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
