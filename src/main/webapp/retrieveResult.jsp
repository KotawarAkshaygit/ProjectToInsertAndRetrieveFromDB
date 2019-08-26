<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	String ename=(String) session.getAttribute("ename");
	int eid=(Integer) session.getAttribute("eid");
	String location=(String) session.getAttribute("location");
	int salary=(Integer) session.getAttribute("salary");
	
	out.println("Employee Details Are .....<br>");
	out.println("Employee Name: "+ename+"<br>");
	out.println("Employee id: "+eid+"<br>");
	out.println("Employee Location: "+ location+"<br>");
	out.println("Employee Salary: "+salary+"<br>");
%>
</body>
</html>