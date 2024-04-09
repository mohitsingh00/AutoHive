package com.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.model.Car;
import com.model.Database;
import com.model.Operation;
import com.model.User;

public class UpdateCar implements Operation{

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println("Enter Car ID: (-1 to show all cars)");
		int ID = sc.nextInt();
		while(ID == -1)
		{
			new ViewCars().operation(database, sc, user);
			System.out.println("Enter car ID: (-1 to show all cars)");
			ID = sc.nextInt();
		}
		
		try
		{
			ResultSet rs1 = database.getStatement().executeQuery("SELECT * FROM `cars` WHERE `ID` = '"+ID+"'");
			rs1.next();
			Car car = new Car();
			car.setID(rs1.getInt("ID"));
			car.setBrand(rs1.getString("Brand"));
			car.setModel(rs1.getString("Model"));
			car.setColor(rs1.getString("Color"));
			car.setYear(rs1.getInt("Year"));
			car.setPrice(rs1.getDouble("Price"));
			car.setAvailable(rs1.getInt("Available"));
			
			if(car.isAvailable() > 1)
			{
				System.out.println("Car doesn't exist!");
				return;
			}
			
			System.out.println("Enter Brand: (-1: "+car.getBrand()+")");
			String brand = sc.next();
			if(brand.equals("-1")) brand = car.getBrand();
			
			System.out.println("Enter Model: (-1: "+car.getModel()+")");
			String model = sc.next();
			if(model.equals("-1")) model = car.getModel();
			
			System.out.println("Enter Color: (-1: "+car.getColor()+")");
			String color = sc.next();
			if(color.equals("-1")) color = car.getColor();
			
			System.out.println("Enter Year: (-1: "+car.getYear()+")");
			int year = sc.nextInt();
			if(year == -1) year = car.getYear();
			
			System.out.println("Enter Price: (-1: "+car.getPrice()+")");
			double price = sc.nextDouble();
			if(price == -1) price = car.getPrice();
			
			String update = "UPDATE `cars` SET `Brand` = '"+brand+"', `Model` = '"+model+"', "
					+ "`Color` = '"+color+"', `Year` = '"+year+"', `Price` = '"+price+"' WHERE `ID` = '"+ID+"';";
			
			database.getStatement().execute(update);
			System.out.println("Car Update Successfully");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
