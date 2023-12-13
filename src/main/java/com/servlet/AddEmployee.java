package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.userDAO;
import com.DB.DBConnection;
import com.utilies.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("Employee_Id"));
		String name = req.getParameter("Employee_Name");
		String email = req.getParameter("Employee_Email");
		String address = req.getParameter("Employee_Address");
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setEmil(email);
		employee.setAddress(address);
		
		userDAO user = new userDAO(DBConnection.getConnection());
		boolean f = user.add(employee);
		PrintWriter out = resp.getWriter();
		
		if(f) {
			//out.print("Data Insert Successfully");
			resp.sendRedirect("Emp.jsp");
			
		}
		else {
			out.print("Data Not Insert Successfully");
		}
		
	}
	
}
