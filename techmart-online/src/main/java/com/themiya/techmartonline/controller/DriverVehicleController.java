package com.themiya.techmartonline.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.themiya.techmartonline.model.Order;
import com.themiya.techmartonline.service.OrderService;

/**
 * Servlet implementation class DriverVehicleController
 */
public class DriverVehicleController extends HttpServlet {
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
			getSpecificOrderDriverId(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
		
		RequestDispatcher rd = request.getRequestDispatcher("orders-driver-vehicle.jsp");
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
		
		RequestDispatcher rd = request.getRequestDispatcher("orders-driver-vehicle.jsp");
		rd.forward(request, response);
	
	}

	private void getSpecificOrderDriverId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		OrderService service = new OrderService();

		int driverId = Integer.parseInt(request.getParameter("driverId"));
		
		Order order = new Order();
		try {
			order = service.getSpecificOrderByDriverId(driverId);
			
			if(order.getProduct().isEmpty()) {

				message = "There's no any order under Driver ID: " + driverId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}	
		
		request.setAttribute("messsage", message);
		request.setAttribute("order", order);
		
		RequestDispatcher rd = request.getRequestDispatcher("orders-driver-vehicle.jsp");
		rd.forward(request, response);
	
	}
}
