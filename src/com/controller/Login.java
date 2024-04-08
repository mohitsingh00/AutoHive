package com.controller;

import java.sql.ResultSet;
import java.util.Scanner;

import com.model.Database;
import com.mysql.cj.protocol.Resultset;

public class Login {

	public Login(Database database, Scanner sc)
	{
		System.out.println("Enter Email: ");
		String email = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		try
		{
			String select = "SELECT * FROM `users`";
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next())
			{
				int ID = rs.getInt("ID");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String em = rs.getString("Email");
				String phoneNumber = rs.getString("PhoneNumber");
				String pass = rs.getString("Password");
				int type = rs.getInt("Type");
			}
		}
		catch (Exception e)
		{
			
		}
	}
}
