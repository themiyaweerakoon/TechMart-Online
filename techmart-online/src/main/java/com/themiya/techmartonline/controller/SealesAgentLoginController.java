package com.themiya.techmartonline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.themiya.techmartonline.dao.SalesAgentLoginManager;

/**
 * Servlet implementation class SealesAgentLoginController
 */
public class SealesAgentLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    int userid = (Integer.parseInt(request.getParameter("userId")));  
	    String pswrd = request.getParameter("userPassword");  
	    
	          
	    if(SalesAgentLoginManager.validate(userid, pswrd)){   
	    	HttpSession session = request.getSession();  
	        session.setAttribute("userid",userid);  
	        
	        RequestDispatcher rd = request.getRequestDispatcher("salesagent-techmart.jsp");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("<b><font color='red'>Sorry! Email or Password Error Occured! Please Try Again...</font></b>");  
	        RequestDispatcher rd = request.getRequestDispatcher("salesagent-login.jsp");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	}  
		

}
