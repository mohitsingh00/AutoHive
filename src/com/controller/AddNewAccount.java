package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.model.Admin;
import com.model.Client;
import com.model.Database;
import com.model.Operation;
import com.model.User;

public class AddNewAccount implements Operation {
	
	private int accType;
	
	public AddNewAccount(int accType)
	{
		this.accType = accType;
	}

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
		 
		try
		{
			String insert = "INSERT INTO `users`(`FirstName`,`LastName`,`Email`,`PhoneNumber`,`Password`,`Type`)"
					+ "VALUES('"+firstName+"','"+lastName+"','"+email+"','"+phoneNumber+"','"+password+"','"+accType+"');";
			
			database.getStatement().execute(insert);
			System.out.println("Account created successfully\n");
			
			if(accType == 0)
			{
				user = new Client();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPhoneNum(phoneNumber);
				user.setPassword(password);
				user.showList(database, sc);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}
