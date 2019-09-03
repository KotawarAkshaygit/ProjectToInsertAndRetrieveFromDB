<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Details</title>
</head>
<body>
<form action="InsertToDB" method="post">
<h3>Insert Details Here</h3>
Enter Employee Name<input type="text" name="ename" required><br>
Enter Emloyee Id<input type="text" name="eid" required><br>
Enter Employee Location<input  type="text" name="location" required><br>
Enter Employee salary<input type="text" name="salary" required><br>
<input type="submit" value="submit">
</body>
</html>