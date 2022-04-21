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

import com.themiya.techmartonline.model.Order;
import com.themiya.techmartonline.service.OrderService;

/**
 * Servlet implementation class OrderController
 */
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllOrders(request, response);
		}
		else {
			getSpecificOrder(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addOrder(request, response);
		}
		else if (action.equals("update")) {
			updateOrder(request, response);
		}
		else if (action.equals("delete")) {
			deleteOrder(request, response);
		}
		
	}
	
	private void getAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		OrderService service = new OrderService();
		try {
			List<Order> orders = service.getAllOrders();
			
			if(orders.isEmpty())
			{
				message = "Sorry, There's no any orders to show!";
			}
			
			request.setAttribute("orderList", orders);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-order.jsp");
		rd.forward(request, response);
		
	}
	
	private void getSpecificOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		OrderService service = new OrderService();
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		Order order = new Order();
		try {
			order = service.getSpecificOrderByOrderId(orderId);
			if(order.getProduct().isEmpty()) {
				message = "There's no any order under Order ID: " + orderId;
				}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}	
		
		request.setAttribute("messsage", message);
		request.setAttribute("order", order);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-search-edit-order.jsp");
		rd.forward(request, response);
	
	}
	
	private void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		OrderService service = new OrderService();
		
		Order order = new Order();
		order.setProductId(Integer.parseInt(request.getParameter("productId")));
		order.setProduct(request.getParameter("product"));
		order.setPrice(Integer.parseInt(request.getParameter("price")));
		order.setBranch(request.getParameter("branch"));
		order.setSalesAgentId(Integer.parseInt(request.getParameter("salesAgentId")));
		order.setSalesAgentName(request.getParameter("salesAgentName"));
		order.setDriverId(Integer.parseInt(request.getParameter("driverId")));
		order.setDriverName(request.getParameter("driverName"));
		order.setVehicleNumber(request.getParameter("vehicleNumber"));
		order.setCustomerEmail(request.getParameter("customerEmail"));
		order.setCustomerName(request.getParameter("customerName"));
		order.setCustomerAddress(request.getParameter("customerAddress"));
		order.setDeliveryStatus(request.getParameter("deliveryStatus"));
		order.setCustomerFeedback(request.getParameter("customerFeedback"));

		try {
			boolean result = service.addOrder(order);
			if(result) {
				message = "The order has been added successfully! Order Name: " + order.getProduct();
			}
			else {
				message = "Failed to add the order! Order Name: " + order.getProduct();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin-add-order.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		OrderService service = new OrderService();
		
		Order order = new Order();
		order.setOrderId(Integer.parseInt(request.getParameter("orderId")));
		order.setProductId(Integer.parseInt(request.getParameter("productId")));
		order.setProduct(request.getParameter("product"));
		order.setPrice(Integer.parseInt(request.getParameter("price")));
		order.setBranch(request.getParameter("branch"));
		order.setSalesAgentId(Integer.parseInt(request.getParameter("salesAgentId")));
		order.setSalesAgentName(request.getParameter("salesAgentName"));
		order.setDriverId(Integer.parseInt(request.getParameter("driverId")));
		order.setDriverName(request.getParameter("driverName"));
		order.setVehicleNumber(request.getParameter("vehicleNumber"));
		order.setCustomerEmail(request.getParameter("customerEmail"));
		order.setCustomerName(request.getParameter("customerName"));
		order.setCustomerAddress(request.getParameter("customerAddress"));
		order.setDeliveryStatus(request.getParameter("deliveryStatus"));
		order.setCustomerFeedback(request.getParameter("customerFeedback"));
		
		try {
			boolean result = service.updateOrder(order);
			if(result) {
				message = "The order has been updated successfully! Order ID: " + order.getOrderId();
			}
			else {
				message = "Failed to update the order! Order ID: " + order.getOrderId();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin-search-edit-order.jsp");
		rd.forward(request, response);
		
	}
	
	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderService service = new OrderService();
		try {
			service.deleteOrder(orderId);
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("/techmart-online/getOrders?action=all");
	}

}
