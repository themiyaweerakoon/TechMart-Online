package com.themiya.techmartonline.controller;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

/**
 * Servlet implementation class LogoutProfile
 */
public class LogoutProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html");  
         PrintWriter out = response.getWriter();  
           
         request.getRequestDispatcher("customer-dashboard.jsp").include(request, response);  
         
         HttpSession session = request.getSession();  
         session.invalidate();  
           
         out.print("You are successfully logged out!");   
           
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
