package com.model;

import java.util.Scanner;

public abstract class User {

	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	
	public User() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNumber;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNumber = phoneNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public abstract void showList(Database database, Scanner sc);
	
	
	
	
	
	
	
	
	
	
	
}
