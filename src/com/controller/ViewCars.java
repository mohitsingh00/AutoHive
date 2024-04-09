package com.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.model.Car;
import com.model.Database;
import com.model.Operation;
import com.model.User;

public class ViewCars implements Operation{

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println();
		String select = "SELECT * FROM `cars`;";
		ArrayList<Car> cars = new ArrayList<>();
		try
		{
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next())
			{
				Car car = new Car();
				car.setID(rs.getInt("ID"));
				car.setBrand(rs.getString("Brand"));
				car.setModel(rs.getString("Model"));
				car.setColor(rs.getString("Color"));
				car.setYear(rs.getInt("Year"));
				car.setPrice(rs.getInt("Price"));
				car.setAvailable(rs.getInt("Available"));
				cars.add(car);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		for(Car c: cars)
		{
			if(c.isAvailable() < 2)
			{
				System.out.println("ID: "+c.getID());
				System.out.println("Brand: "+c.getBrand());
				System.out.println("Model: "+c.getModel());
				System.out.println("Color: "+c.getColor());
				System.out.println("Year: "+c.getYear());
				System.out.println("Price: $"+c.getPrice());
				if(c.isAvailable() == 0)
				{
					System.out.println("Status: Available");
				}
				else
				{
					System.out.println("Status: Not Available");
				}
				System.out.println("-------------------------------------------------");
			}
		}
		System.out.println();
		
	}

}
