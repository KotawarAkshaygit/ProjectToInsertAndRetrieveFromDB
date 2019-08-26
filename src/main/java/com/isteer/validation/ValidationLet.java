package com.isteer.validation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidationLet
 */
public class ValidationLet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int opt=Integer.parseInt(request.getParameter("opt"));
		
		
		switch(opt)
		{
		case 1:
		{
			//RequestDispatcher rd=request.getRequestDispatcher("insertDB.jsp");
			
			response.sendRedirect("insertDB.jsp");
			break;
			
		}
		case 2:
		{
			//RequestDispatcher rd=request.getRequestDispatcher("retrieveDB.jsp");
			response.sendRedirect("retrieveDB.jsp");
			break;
		}
		 default:
		{
		
			RequestDispatcher rd=request.getRequestDispatcher("InvalidCode.jsp");
			rd.forward(request, response);
		}
		}
	}

}
