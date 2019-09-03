package com.isteer.insertToDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isteer.dbConnections.DbConnections;



/**
 * Servlet implementation class InsertToDB
 */
public class InsertToDB extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String ename=request.getParameter("ename");
		int eid=Integer.parseInt(request.getParameter("eid"));
		String location=request.getParameter("location");
		int salary=Integer.parseInt(request.getParameter("salary"));
		try
		{

			Connection con = DbConnections.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into employee_details values( ,?,?,?,?)");
			pst.setString(1, ename);
			pst.setInt(2, eid);
			pst.setString(3,location);
			pst.setInt(4, salary);
			pst.executeUpdate();
			
			
			HttpSession session=request.getSession();
			session.setAttribute("result", eid);
			session.setAttribute("name",ename);
			//RequestDispatcher rd=request.getRequestDispatcher("insertResult.jsp");
			response.sendRedirect("insertResult.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("enable to connect");
		}
	}

}
