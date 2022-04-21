package com.themiya.techmartonline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.themiya.techmartonline.model.Product;
import com.themiya.techmartonline.service.ProductService;  

/**
 * Servlet implementation class CustomerProducts
 */
public class CustomerProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter(); 
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			
			String user = (String)session.getAttribute("user"); 
			out.print("Account: " + user);
		     
		} else {
			
			out.print("Login First");
		}

		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllProducts(request, response);
		}
		else {
			getSpecificProduct(request, response);
		} 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equals("order")) {
			orderProduct(request, response);
		}

	}
	
	private void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		ProductService service = new ProductService();
		try {
			List<Product> products = service.getAllProducts();
			
			if(products.isEmpty())
			{
				message = "Sorry, There's no any products to show!";
			}
			
			request.setAttribute("productList", products);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("customer-products.jsp");
		rd.forward(request, response);
		
	}
	
	private void getSpecificProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		ProductService service = new ProductService();
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		
		Product product = new Product();
		try {
			product = service.getSpecificProductByProductCode(productCode);
			if(product.getProductName().isEmpty()) {
				message = "There's no any product under Product Code: " + productCode;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}	
		
		request.setAttribute("messsage", message);
		request.setAttribute("product", product);
		
		RequestDispatcher rd = request.getRequestDispatcher("customer-products.jsp");
		rd.forward(request, response);
	
	}
	
	private void orderProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			
			String message = "";
			int productCode = Integer.parseInt(request.getParameter("productCode"));
			String customerEmail = request.getParameter("customerEmail");
			session.setAttribute("user", customerEmail);
			ProductService service = new ProductService();
			

			try {
				service.orderProduct(productCode, customerEmail);
				
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("customer-search-edit-order.jsp");
			rd.forward(request, response);
			
		}
		     
		else {
			
			out.print("Login First");
		
	}

		
	}


}
