package com.controller;

import java.util.Scanner;
import com.model.Database;
import com.model.Operation;
import com.model.User;

public class EditUserData implements Operation{

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println("Enter First Name: (-1 to keep "+user.getFirstName()+")");
		String firstName = sc.next();
		if(firstName.equals("-1")) firstName = user.getFirstName();
		
		System.out.println("Enter Last Name: (-1 to keep "+user.getLastName()+")");
		String lastName = sc.next();
		if(lastName.equals("-1")) lastName = user.getLastName();
		
		System.out.println("Enter Email: (-1 to keep "+user.getEmail()+")");
		String email = sc.next();
		if(email.equals("-1")) email = user.getEmail();
		
		System.out.println("Enter Phone Number: (-1 to keep "+user.getPhoneNum()+")");
		String phoneNumber = sc.next();
		if(phoneNumber.equals("-1")) phoneNumber = user.getPhoneNum();
		
		String update = "UPDATE `users` SET `FirstName`= '"+firstName+"', `LastName`= '"+lastName+"', "
				+ "`Email`= '"+email+"', `PhoneNumber`= '"+phoneNumber+"' WHERE `ID` = '"+user.getID()+"'";
		
		try
		{
			database.getStatement().execute(update);
			System.out.println("Profile Updated Successfuly");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
