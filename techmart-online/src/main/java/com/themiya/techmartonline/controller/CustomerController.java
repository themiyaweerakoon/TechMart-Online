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

import com.themiya.techmartonline.model.Customer;
import com.themiya.techmartonline.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllCustomers(request, response);
		}
		else {
			getSpecificCustomer(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addCustomer(request, response);
		}
		else if (action.equals("update")) {
			updateCustomer(request, response);
		}
		else if (action.equals("delete")) {
			deleteCustomer(request, response);
		}

	}
	
	private void getAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		CustomerService service = new CustomerService();
		try {
			List<Customer> customers = service.getAllCustomers();
			
			if(customers.isEmpty())
			{
				message = "Sorry, There's no any customer to show!";
			}
			
			request.setAttribute("customerList", customers);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("techmart-customers-jstl.jsp");
		rd.forward(request, response);
		
	}
	
	private void getSpecificCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		CustomerService service = new CustomerService();
		String customerEmail = request.getParameter("customerEmail");
		
		Customer customer = new Customer();
		try {
			customer = service.getSpecificCustomerByCustomerEmail(customerEmail);
			if(customer.getCustomerName().isEmpty()) {
				message = "There's no any customer under Customer Email: " + customerEmail;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}	
		
		request.setAttribute("messsage", message);
		request.setAttribute("customer", customer);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-customer.jsp");
		rd.forward(request, response);
	
	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				message = "The customer has been added successfully! Customer Name: " + customer.getCustomerName();
			}
			else {
				message = "Failed to add the customer! Customer Name: " + customer.getCustomerName();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			boolean result = service.updateCustomer(customer);
			if(result) {
				message = "The customer has been updated successfully! Customer Email: " + customer.getCustomerEmail();
			}
			else {
				message = "Failed to update the customer! Customer Email: " + customer.getCustomerEmail();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-customer.jsp");
		rd.forward(request, response);
		
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		String customerEmail = request.getParameter("customerEmail");
		CustomerService service = new CustomerService();
		try {
			service.deleteCustomer(customerEmail);
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("/techmart-online/getCustomer?action=all");
	}

}
