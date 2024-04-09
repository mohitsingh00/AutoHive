package com.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rent {

	private int ID;
	private User user;
	private Car car;
	private LocalDateTime dateTime;
	private int hours;
	private double total;
	private int status;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm");
	
	//Status 0 -> running
	//       1 -> returned
	
	public Rent() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getDateTime() {
		return formatter.format(dateTime) ;
	}

	public void setDateTime(String dateTimeString) {
		this.dateTime = LocalDateTime.parse(dateTimeString,formatter);
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	
	
	
	
	
	
	
	
	
}
