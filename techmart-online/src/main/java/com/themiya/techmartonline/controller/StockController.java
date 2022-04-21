package com.themiya.techmartonline.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.themiya.techmartonline.model.Product;
import com.themiya.techmartonline.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
public class StockController extends HttpServlet {
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
		

		if (action.equals("update")) {
			updateStock(request, response);
		}
		
	} 
	
	private void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		ProductService service = new ProductService();
		try {
			List<Product> products = service.getAllProducts();
			
			if(products.isEmpty())
			{
				message = "Sorry, There's no any stock to show!";
			}
			
			request.setAttribute("productList", products);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("techmart-stock.jsp");
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
				message = "There's no any stock under Product Code: " + productCode;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}	
		
		request.setAttribute("messsage", message);
		request.setAttribute("product", product);
		
		RequestDispatcher rd = request.getRequestDispatcher("update-stock.jsp");
		rd.forward(request, response);
	
	}
	
	private void updateStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				message = "The stock has been updated successfully! Product Code: " + product.getProductCode();
			}
			else {
				message = "Failed to update the stock! Product Code: " + product.getProductCode();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-stock.jsp");
		rd.forward(request, response);
		
	}

}
