package com.isteer.retriveDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Retrieve
 */
public class Retrieve extends HttpServlet {
	
	String ename;
	int eid;
	String location;
	int salary;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","root");
			
			PreparedStatement pt=con.prepareStatement("select * from employee_details where eid="+id);
			ResultSet rs=pt.executeQuery();
			
			while(rs.next())
			{
				 ename=rs.getString(1);
				eid= rs.getInt(2);
				 location=rs.getString(3);
				 salary=rs.getInt(4);
			}
			
			HttpSession session=request.getSession();
			session.setAttribute("ename", ename);
			session.setAttribute("eid", eid);
			session.setAttribute("location", location);
			session.setAttribute("salary", salary);
			
		response.sendRedirect("retrieveResult.jsp");
			//RequestDispatcher rd=request.getRequestDispatcher("retieveResult.jsp");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
