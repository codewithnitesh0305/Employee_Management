<%@page import="com.DAO.userDAO"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="com.utilies.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/style1.css">
</head>
<body>
	<div class="container">

		<table>
			<h2>Employee Details</h2>
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Email</th>
				<th>Employee Address</th>
				<th>Action</th>
				
			</tr>
				<%
				userDAO user = new userDAO(DBConnection.getConnection());
				List<Employee> list = user.fetch();
				for (Employee emp : list) {
				%>
			<tr>

				<td><%=emp.getId()%></td>
				<td><%=emp.getName()%></td>
				<td><%=emp.getEmil()%></td>
				<td><%=emp.getAddress()%></td>
				<td>
					<a href="edit.jsp?id=<%=emp.getId() %>" class="edit">Edit</a>
					<a href="Delete?Employee_Id=<%=emp.getId() %>" class="delete">Delete</a>
				</td>
				

			</tr>
			<%
				}
			%>
		</table>
		<a href="index.jsp" style="margin: auto;">Add Details</a>
	</div>
</body>
</html>