package com.themiya.techmartonline.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.themiya.techmartonline.model.Customer;
import com.themiya.techmartonline.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addCustomerRegister(request, response);
		}
		
	}
	

	private void addCustomerRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String message = "";
		CustomerService service = new CustomerService();
		
		Customer customer = new Customer();
		customer.setCustomerEmail(request.getParameter("customerEmail"));
		customer.setCustomerName(request.getParameter("customerName"));
		customer.setCustomerAddress(request.getParameter("customerAddress"));
		customer.setCustomerPassword(request.getParameter("customerPassword"));
		customer.setCustomerBranch(request.getParameter("customerBranch"));
		customer.setCustomerPaymentMethod(request.getParameter("customerPaymentMethod"));
	
		try {
			boolean result = service.addCustomer(customer);
			if(result) {
				message = "You have registered successfully! Customer Name: " + customer.getCustomerName();
			}
			else {
				message = "Failed to register! Try Again... Customer Name: " + customer.getCustomerName();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("register-customer.jsp");
		rd.forward(request, response);
	
	}

}
