package com.controller;

import java.util.Scanner;

import com.model.Database;
import com.model.Operation;
import com.model.User;

public class UpdateCar implements Operation{

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println("Enter Car ID: (-1 to show all cars)");
		int ID = sc.nextInt();
		String update = "UPDATE `cars` SET `ID` = '', `Brand` = '', `Model` = '', `Color` = '', `Year` = '', `Price` = '', `Available` = '' WHERE `ID` = '';";
	}

}
