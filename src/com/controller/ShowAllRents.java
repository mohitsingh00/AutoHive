package com.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.model.Car;
import com.model.Client;
import com.model.Database;
import com.model.Operation;
import com.model.Rent;
import com.model.User;

public class ShowAllRents implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		ArrayList<Rent> rents = new ArrayList<>();
		ArrayList<Integer> carIDs = new ArrayList<>();
		ArrayList<Integer> userIDs = new ArrayList<>();
		try
		{
			String select = "SELECT * FROM `rents`;";
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next())
			{
				Rent rent = new Rent();
				rent.setID(rs.getInt("ID"));
				userIDs.add(rs.getInt("User"));
				carIDs.add(rs.getInt("Car"));
				rent.setDateTime(rs.getString("DateTime"));
				rent.setHours(rs.getInt("Hours"));
				rent.setTotal(rs.getDouble("Total"));
				rent.setStatus(rs.getInt("Status"));
				rents.add(rent);
			}
			
			for(int j = 0; j < rents.size(); j++)
			{
				Rent r = rents.get(j);
				
				String selectUser = "SELECT * FROM `users` WHERE `ID` = '"+userIDs.get(j)+"';";
				ResultSet rs2 = database.getStatement().executeQuery(selectUser);
				rs2.next();
				User u = new Client();
				u.setID(rs2.getInt("ID"));
				u.setFirstName(rs2.getString("FirstName"));
				u.setLastName(rs2.getString("LastName"));
				u.setEmail(rs2.getString("Email"));
				u.setPhoneNum(rs2.getString("PhoneNumber"));
				u.setPassword(rs2.getString("Password"));
				r.setUser(u);
				
				ResultSet rs3 = database.getStatement()
				.executeQuery("SELECT * FROM `cars` WHERE `ID` = '"+carIDs.get(j)+"';");
				
				rs3.next();
				Car car = new Car();
				car.setID(rs3.getInt("ID"));
				car.setBrand(rs3.getString("Brand"));
				car.setModel(rs3.getString("Model"));
				car.setColor(rs3.getString("Color"));
				car.setYear(rs3.getInt("Year"));
				car.setPrice(rs3.getInt("Price"));
				car.setAvailable(rs3.getInt("Available"));
				r.setCar(car);
				
				System.out.println("ID: "+r.getID());
				System.out.println("Name: "+r.getUser().getFirstName()+" "+r.getUser().getLastName());
				System.out.println("Email: "+r.getUser().getEmail());
				System.out.println("Phone Number: "+r.getUser().getPhoneNum());
				System.out.println("Car ID: "+r.getCar().getID());
				System.out.println("Car: "+r.getCar().getBrand()+" "+r.getCar().getModel()+" "+r.getCar().getColor());
				System.out.println("Date Time: "+r.getDateTime());
				System.out.println("Hours: "+r.getHours());
				System.out.println("Total: "+r.getTotal());
				System.out.println("Status: "+r.getStatusToString());
				System.out.println("--------------------------------------");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
