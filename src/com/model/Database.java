package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	private String user = "root";
	private String password = "Mohit@123";
	private String url = "jdbc:mysql://localhost:3306/carrentalsystem";
	private Statement statement;
	
	public Database()
	{
		try
		{
			Connection con = DriverManager.getConnection(url,user,password);
			statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public Statement getStatement()
	{
		return statement;
	}
}
