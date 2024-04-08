package com.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.model.Database;
import com.model.Operation;
import com.model.User;

public class AddNewClient implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user)
	{
		System.out.println("Enter First Name: ");
		String firstName = sc.next();
		System.out.println("Enter Last Name: ");
		String lastName = sc.next();
		System.out.println("Enter Email: ");
		String email = sc.next();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		System.out.println("Confirm Password: ");
		String confirmPassword = sc.next();
		
		while(!password.equals(confirmPassword))
		{
			System.out.println("Password doesn't match");
			System.out.println("Enter Password: ");
			password = sc.next();
			System.out.println("Confirm Password: ");
			confirmPassword = sc.next();
		}
		
		int accType = 0;
		try
		{
			ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*);");
			rs.next();
			int ID = rs.getInt("COUNT(*)") - 1;
			String insert = "INSERT INTO `users`(`ID`,`FirstName`,`LastName`,`Email`,`PhoneNumber`,`Password`,`Type`)"
					+ "VALUES('"+ID+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNumber+"','"+password+"','"+accType+"');";
			
			database.getStatement().execute(insert);
			System.out.println("Client account created successfully\n");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
