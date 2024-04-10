package com.controller;

import java.sql.ResultSet;
import java.util.Scanner;

import com.model.Database;
import com.model.Operation;
import com.model.User;

public class ShowSpecUserRents implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println("Enter User ID: (-1 to show all users)");
		int ID = sc.nextInt();
		while(ID == -1)
		{
			printUsers(database);
			System.out.println("Enter User ID: (-1 to show all users)");
			ID = sc.nextInt();
		}
		new ShowUserRents(ID).operation(database, sc, user);
	}
	
	private void printUsers(Database database)
	{
		try
		{
			ResultSet rs = database.getStatement().executeQuery("SELECT * FROM `users`;");
			while(rs.next())
			{
				int accType = rs.getInt("Type");
				if(accType == 0)
				{
					System.out.println("ID: "+rs.getInt("ID"));
					System.out.println("First Name: "+rs.getString("FirstName"));
					System.out.println("Last Name: "+rs.getString("LastName"));
					System.out.println("Email: "+rs.getString("Email"));
					System.out.println("Phone Number: "+rs.getString("PhoneNumber"));
					System.out.println("-----------------------------------------------");
				}
			}
		}
		catch (Exception e)  
		{
			e.printStackTrace();
		}
	}

}
