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

import com.themiya.techmartonline.model.Product;
import com.themiya.techmartonline.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllProducts(request, response);
		}
		else {
			getSpecificProduct(request, response);
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
			addProduct(request, response);
		}
		else if (action.equals("update")) {
			updateProduct(request, response);
		}
		else if (action.equals("delete")) {
			deleteProduct(request, response);
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
		
		RequestDispatcher rd = request.getRequestDispatcher("techmart-products-jstl.jsp");
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
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-product.jsp");
		rd.forward(request, response);
	
	}
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		ProductService service = new ProductService();
		
		Product product = new Product();
		product.setProductCode(Integer.parseInt(request.getParameter("productCode")));
		product.setProductName(request.getParameter("productName"));
		product.setProductDescription(request.getParameter("productDescription"));
		product.setProductPrice(Double.parseDouble(request.getParameter("productPrice")));
		product.setProductQuantity(Integer.parseInt(request.getParameter("productQuantity")));
		product.setProductSupplier(request.getParameter("productSupplier"));
		product.setProductStock(Integer.parseInt(request.getParameter("productStock")));
		try {
			boolean result = service.addProduct(product);
			if(result) {
				message = "The product has been added successfully! Product Name: " + product.getProductName();
			}
			else {
				message = "Failed to add the product! Product Name: " + product.getProductName();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-product.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		ProductService service = new ProductService();
		
		Product product = new Product();
		product.setProductCode(Integer.parseInt(request.getParameter("productCode")));
		product.setProductName(request.getParameter("productName"));
		product.setProductDescription(request.getParameter("productDescription"));
		product.setProductPrice(Double.parseDouble(request.getParameter("productPrice")));
		product.setProductQuantity(Integer.parseInt(request.getParameter("productQuantity")));
		product.setProductSupplier(request.getParameter("productSupplier"));
		product.setProductStock(Integer.parseInt(request.getParameter("productStock")));
		try {
			boolean result = service.updateProduct(product);
			if(result) {
				message = "The product has been updated successfully! Product Code: " + product.getProductCode();
			}
			else {
				message = "Failed to update the product! Product Code: " + product.getProductCode();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-product.jsp");
		rd.forward(request, response);
		
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		ProductService service = new ProductService();
		try {
			service.deleteProduct(productCode);
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("/techmart-online/getProducts?action=all");
	}
	

}
