package com.isteer.retriveDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;

import com.isteer.dbConnections.DbConnections;

import org.apache.logging.log4j.LogManager;

/**
 * Servlet implementation class Retrieve
 */
public class Retrieve extends HttpServlet {

	String ename;
	int eid;
	String location;
	int salary;
	private static Logger logger = LogManager.getLogger(Retrieve.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession();
		
		ServletContext ctx=request.getServletContext();
		String url=ctx.getInitParameter("URL");
		logger.info(url);
		ServletContext ctx1=request.getServletContext();
		String password=ctx1.getInitParameter("password");
		
		ServletContext ctx2=request.getServletContext();
		String username=ctx2.getInitParameter("username");
		
		ServletContext ctx3=request.getServletContext();
		String driver=ctx3.getInitParameter("driver");
		logger.info(driver);

	try {            
		
			
			//Connection con = DbConnections.getConnection();
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement pt = con.prepareStatement("select * from employee_details where eid=" + id);
			System.out.println("In Connnnn");
			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				ename = rs.getString(1);
				eid = rs.getInt(2);
				location = rs.getString(3);
				salary = rs.getInt(4);
			}
			if (ename == null) {

				String mess = "Please Insert Correct Employee Id";
				session.setAttribute("mess", mess);
				logger.info("redirecting to retrieveresult jsp");
				response.sendRedirect("retrieveResult.jsp");
				System.out.println("Insert Correct details");
			} else {
				session.setAttribute("ename", ename);
				session.setAttribute("eid", eid);
				session.setAttribute("location", location);
				session.setAttribute("salary", salary);

				response.sendRedirect("retrieveResult.jsp");
				// RequestDispatcher rd=request.getRequestDispatcher("retieveResult.jsp");
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

}
