package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.utilies.Employee;
import com.utilies.Employee_Details;

public class userDAO {
	private Connection connection = null;

	public userDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	//Insert the data in database
	public boolean add(Employee emp) {
		boolean f = false;
		try {
			String query = "Insert into employee1(Id,Name,Email,Address) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, emp.getId());
			preparedStatement.setString(2, emp.getName());
			preparedStatement.setString(3, emp.getEmil());
			preparedStatement.setString(4, emp.getAddress());
			
			int i = preparedStatement.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	// Retrieve the data and show in Emp.jsp page
	public List<Employee> fetch() {
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;
		try {
			String query = "Select * from employee1";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				employee = new Employee();
				employee.setId(resultset.getInt(1));
				employee.setName(resultset.getString(2));
				employee.setEmil(resultset.getString(3));
				employee.setAddress(resultset.getString(4));
				list.add(employee);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//Update the employee data
	public boolean update( Employee employee) {
		boolean f = false;
		try {
			String query = "update employee1 set name = ?, email = ?, address = ? where id = ?";
			PreparedStatement preparedstatment = connection.prepareStatement(query);			
			preparedstatment.setString(1, employee.getName());
			preparedstatment.setString(2, employee.getEmil());
			preparedstatment.setString(3, employee.getAddress());
			preparedstatment.setInt(4, employee.getId());
			int i = preparedstatment.executeUpdate();
			if(i == 1) {
				f = true;
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	//Retrieve data from database in edit page to show the employee details
	public Employee getDataById(int id) {
		Employee employee = null;
		try {
			String query = "select * from employee1 where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				employee = new Employee();
				employee.setId(resultset.getInt(1));
				employee.setName(resultset.getString(2));
				employee.setEmil(resultset.getString(3));
				employee.setAddress(resultset.getString(4));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	//Delete the Employee Data
	public boolean delete(int id) {
		boolean f = false;
		try {
			String query = "Delete from employee1 where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int i = preparedStatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
