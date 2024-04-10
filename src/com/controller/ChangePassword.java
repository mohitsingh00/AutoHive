package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.model.Database;
import com.model.Operation;
import com.model.User;

public class ChangePassword implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println("Enter Old Password: ");
		String oldPassword = sc.next();
		if(!oldPassword.equals(user.getPassword()))
		{
			System.out.println("Password doesn't match");
			return;
		}
		System.out.println("Enter New Password");
		String newPassword = sc.next();
		System.out.println("Confirm Password");
		String confirmPassword = sc.next();
		while(!newPassword.equals(confirmPassword))
		{
			System.out.println("Password doesn't match");
			System.out.println("Enter New Password");
			newPassword = sc.next();
			System.out.println("Confirm Password");
			confirmPassword = sc.next();
		}
		try
		{
			String update = "UPDATE `users` SET `Password`= '"+newPassword+"' WHERE `ID` = '"+user.getID()+"';";
			database.getStatement().execute(update);
			System.out.println("Password Changed Successfully");
			user.setPassword(newPassword);
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
