package com.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import com.model.Admin;
import com.model.Client;
import com.model.Database;
import com.model.User;

public class Login {

	public static void main(String[] args) {
		Database database = new Database();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("WELCOME TO CAR RENTAL SYSTEM");
		System.out.println("Enter Email: \n(-1) to create new account");
		String email = sc.next();
		if(email.equals("-1"))
		{
			new AddNewAccount(0).operation(database, sc, null);
			return;
		}
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		ArrayList<User> users = new ArrayList<>();
		
		try 
		{
			String select = "SELECT * FROM `users`";
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next())
			{
				User user;
				int ID = rs.getInt("ID");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String em = rs.getString("Email");
				String phoneNumber = rs.getString("PhoneNumber");
				String pass = rs.getString("Password");
				int type = rs.getInt("Type");
				
				if(type == 0)
				{
					user = new Client();
					user.setID(ID);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setEmail(em);
					user.setPhoneNum(phoneNumber);
					user.setPassword(pass);
					users.add(user);
				}
				else if(type == 1)
				{
					user = new Admin();
					user.setID(ID);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setEmail(em);
					user.setPhoneNum(phoneNumber);
					user.setPassword(pass);
					users.add(user);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		boolean loogedIn = false;
		for(User u : users)
		{
			if(u.getEmail().equals(email) && u.getPassword().equals(password))
			{
				System.out.println("Welcome "+u.getFirstName()+"!");
				loogedIn = true;
				u.showList(database, sc);
			}
		}
		if(!loogedIn)
		{
			System.out.println("Invalid Email or Password");
			sc.close();
		}
	}
}
