package com.themiya.techmartonline.controller; 

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoggedInProfile
 */
public class LoggedInProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html");  
	     PrintWriter out = response.getWriter();  
	     request.getRequestDispatcher("customer-dashboard.jsp").include(request, response);  
	          
	     HttpSession session = request.getSession(false);
	     
	     if(session!=null){  
	    	 
	     String user = (String)session.getAttribute("user");  
	          
	     out.print("Hello, "+ user +"...! Welcome to your Profile");  
	     }  
	     else{  
	        out.print("Please login first");  
	        request.getRequestDispatcher("customer-dashboard.jsp").include(request, response);  
	     }  
	     out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
