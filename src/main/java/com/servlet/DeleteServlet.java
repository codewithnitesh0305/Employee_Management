package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.userDAO;
import com.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("Employee_Id"));
		userDAO user = new userDAO(DBConnection.getConnection());
		boolean f =  user.delete(id);
		PrintWriter out = resp.getWriter();
		if(f) {
			//out.print("Data delete");
			resp.sendRedirect("Emp.jsp");
		}
		else {
			out.print("Data not delete");
			
		}
	}

	
	

}
