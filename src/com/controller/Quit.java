package com.controller;

import java.util.Scanner;

import com.model.Database;
import com.model.Operation;
import com.model.User;

public class Quit implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user) 
	{
		System.out.println("Thank You for Visiting Us !");
		
	}

}
