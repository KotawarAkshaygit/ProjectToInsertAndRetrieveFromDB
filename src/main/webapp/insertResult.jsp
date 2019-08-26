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
	
	int eid=(Integer)(session.getAttribute("result"));
	String ename=(String) session.getAttribute("name");
	
	out.println("Successfully inserted to DataBase of id= "+ eid +" name= "+ ename);
	
%>
</body>
</html>