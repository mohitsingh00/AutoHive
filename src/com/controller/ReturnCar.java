package com.controller;

import java.sql.ResultSet;
import java.util.Scanner;

import com.model.Database;
import com.model.Operation;
import com.model.Rent;
import com.model.User;

public class ReturnCar implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user)
	{
		System.out.println("Enter Rent ID: (-1 to show all rents)");
		int ID = sc.nextInt();
		while(ID == -1)
		{
			new ShowUserRents(user.getID()).operation(database, sc, user);
			System.out.println("Enter Rent ID: (-1 to show all rents)");
			ID = sc.nextInt();
		}
		
		try
		{
			String select = "SELECT * FROM `rents` WHERE `ID` = '"+ID+"';";
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			Rent r = new Rent();
			r.setID(rs.getInt(ID));
			r.setUser(user);
			r.setDateTime(rs.getString("DateTime"));
			r.setHours(rs.getInt("Hours"));
			r.setTotal(rs.getDouble("Total"));
			r.setStatus(rs.getInt("Status"));
			
			if(r.getStatusToString().equals("Delayed"))
			{
				System.out.println(r.getDelayedHours()+" delayed hours");
				System.out.println("You will have to pay $"+r.getDelayedHours() * 100+" as fine");
			}
			
			String update = "UPDATE `rents` SET `Status` = '1' WHERE `ID` = '"+ID+"';";
			database.getStatement().execute(update);
			System.out.println("Car returned successfully");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
