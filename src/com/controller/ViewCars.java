package com.controller;

import java.sql.ResultSet;
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
		try
		{
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next())
			{
				Car car = new Car();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println();
		
	}

}
