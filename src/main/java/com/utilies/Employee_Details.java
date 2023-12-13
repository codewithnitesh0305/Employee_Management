package com.utilies;

public class Employee_Details {
	private int Id;
	private String Name;
	private String Email;
	private String Address;
	
	public Employee_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee_Details(int id, String name, String email, String address) {
		super();
		Id = id;
		Name = name;
		Email = email;
		Address = address;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
}
