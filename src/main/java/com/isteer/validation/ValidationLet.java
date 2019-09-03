package com.isteer.validation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import demoIsteer.Test;

/**
 * Servlet implementation class ValidationLet
 */
public class ValidationLet extends HttpServlet {
	
	private static org.apache.logging.log4j.Logger logger=LogManager.getLogger(ValidationLet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int opt=Integer.parseInt(request.getParameter("opt"));
		
		
		switch(opt)
		{
		case 1:
		{
			//RequestDispatcher rd=request.getRequestDispatcher("insertDB.jsp");
			logger.info("Redirecting to insertDb jspage ");
			response.sendRedirect("insertDB.jsp");
		
			break;
			
		}
		case 2:
		{
			//RequestDispatcher rd=request.getRequestDispatcher("retrieveDB.jsp");
			logger.info("redirecting to retieveDb jsp");
			response.sendRedirect("retrieveDB.jsp");
		
			break;
		}
		 default:
		{
		
			logger.info("redirecting to invalidcode jsp");
			RequestDispatcher rd=request.getRequestDispatcher("InvalidCode.jsp");
			
			rd.forward(request, response);
		}
		}
	}

}
