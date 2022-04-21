package com.themiya.techmartonline.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.themiya.techmartonline.model.SalesAgent;
import com.themiya.techmartonline.service.SalesAgentService;

/**
 * Servlet implementation class ProductController
 */
public class SalesAgentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllSalesAgents(request, response);
		}
		else {
			getSpecificSalesAgent(request, response);
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("techmart-products.jsp");
		//rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addSalesAgent(request, response);
		}
		else if (action.equals("update")) {
			updateSalesAgent(request, response);
		}
		else if (action.equals("delete")) {
			deleteSalesAgent(request, response);
		}
		
	} 
	
	private void getAllSalesAgents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		SalesAgentService service = new SalesAgentService();
		try {
			List<SalesAgent> salesagent = service.getAllSalesAgents();
			
			if(salesagent.isEmpty())
			{
				message = "Sorry, There's no any sales agents to show!";
			}
			
			request.setAttribute("salesAgentList", salesagent);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("techmart-salesagents-jstl.jsp");
		rd.forward(request, response);
		
	}
	
	private void getSpecificSalesAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		SalesAgentService service = new SalesAgentService();
		int salesAgentId = Integer.parseInt(request.getParameter("salesAgentId"));
		
		SalesAgent salesagent = new SalesAgent();
		try {
			salesagent = service.getSpecificSalesAgentBySalesAgentId(salesAgentId);
			if(salesagent.getSalesAgentName().isEmpty()) {
				message = "There's no any sales agent under sales agent ID: " + salesAgentId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}	
		
		request.setAttribute("messsage", message);
		request.setAttribute("salesagent", salesagent);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-salesagent.jsp");
		rd.forward(request, response);
	
	}
	
	private void addSalesAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		SalesAgentService service = new SalesAgentService();
		
		SalesAgent salesagent = new SalesAgent();
		salesagent.setSalesAgentName(request.getParameter("salesAgentName"));
		salesagent.setSalesAgentBranch(request.getParameter("salesAgentBranch"));
		salesagent.setSalesAgentPassword(request.getParameter("salesAgentPassword"));
		try {
			boolean result = service.addSalesAgent(salesagent);
			if(result) {
				message = "The sales agent has been added successfully! Sales Agent Name: " + salesagent.getSalesAgentName();
			}
			else {
				message = "Failed to add the sales agent! Sales Agent Name: " + salesagent.getSalesAgentName();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-salesagent.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateSalesAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		SalesAgentService service = new SalesAgentService();
		
		SalesAgent salesagent = new SalesAgent();
		salesagent.setSalesAgentId(Integer.parseInt(request.getParameter("salesAgentId")));
		salesagent.setSalesAgentName(request.getParameter("salesAgentName"));
		salesagent.setSalesAgentBranch(request.getParameter("salesAgentBranch"));
		salesagent.setSalesAgentPassword(request.getParameter("salesAgentPassword"));
		try {
			boolean result = service.updateSalesAgent(salesagent);
			if(result) {
				message = "The sales agent has been updated successfully! Sales Agent Code: " + salesagent.getSalesAgentId();
			}
			else {
				message = "Failed to update the sales agent! Sales Agent Code: " + salesagent.getSalesAgentId();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-salesagent.jsp");
		rd.forward(request, response);
		
	}
	
	private void deleteSalesAgent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int salesAgentId = Integer.parseInt(request.getParameter("salesAgentId"));
		SalesAgentService service = new SalesAgentService();
		try {
			service.deleteSalesAgent(salesAgentId);
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("/techmart-online/getSalesAgents?action=all");
	}

}