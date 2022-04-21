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

import com.themiya.techmartonline.model.Delivery;
import com.themiya.techmartonline.service.DeliveryService;

/**
 * Servlet implementation class DeliveryController
 */
public class DeliveryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllDeliveries(request, response);
		}
		else {
			getSpecificDelivery(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addDelivery(request, response);
		}
		else if (action.equals("update")) {
			updateDelivery(request, response);
		}
		else if (action.equals("delete")) {
			deleteDelivery(request, response);
		}

	}
	
	private void getAllDeliveries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		DeliveryService service = new DeliveryService();
		try {
			List<Delivery> deliveries = service.getAllDeliveries();
			
			if(deliveries.isEmpty())
			{
				message = "Sorry, There's no any delivery drivers and vehicles to show!";
			}
			
			request.setAttribute("deliveryList", deliveries);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("techmart-deliveries.jsp");
		rd.forward(request, response);
		
	}
	
	private void getSpecificDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		DeliveryService service = new DeliveryService();
		int driverId = Integer.parseInt(request.getParameter("driverId"));
		
		Delivery delivery = new Delivery();
		try {
			delivery = service.getSpecificDeliveryByDriverId(driverId);
			if(delivery.getDriverName().isEmpty()) {
				message = "There's no any driver and vehicle under Driver ID: " + driverId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}	
		
		request.setAttribute("messsage", message);
		request.setAttribute("delivery", delivery);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-delivery.jsp");
		rd.forward(request, response);
	
	}
	
	private void addDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		DeliveryService service = new DeliveryService();
		
		Delivery delivery = new Delivery();
		delivery.setDriverName(request.getParameter("driverName"));
		delivery.setDriverBranch(request.getParameter("driverBranch"));
		delivery.setVehicleNumber(request.getParameter("vehicleNumber"));
		delivery.setVehicleType(request.getParameter("vehicleType"));
		
		try {
			boolean result = service.addDelivery(delivery);
			if(result) {
				message = "The delivery driver and vehicle has been added successfully! Driver Name: " + delivery.getDriverName();
			}
			else {
				message = "Failed to add the driver and vehicle! Driver Name: " + delivery.getDriverName();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-delivery.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		DeliveryService service = new DeliveryService();
		
		Delivery delivery = new Delivery();
		delivery.setDriverId(Integer.parseInt(request.getParameter("driverId")));
		delivery.setDriverName(request.getParameter("driverName"));
		delivery.setDriverBranch(request.getParameter("driverBranch"));
		delivery.setVehicleNumber(request.getParameter("vehicleNumber"));
		delivery.setVehicleType(request.getParameter("vehicleType"));
		
		try {
			boolean result = service.updateDelivery(delivery);
			if(result) {
				message = "The delivery driver and vehicle has been updated successfully! Driver ID: " + delivery.getDriverId();
			}
			else {
				message = "Failed to update the driver and vehicle! Driver ID: " + delivery.getDriverId();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-delivery.jsp");
		rd.forward(request, response);
		
	}
	
	private void deleteDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int driverId = Integer.parseInt(request.getParameter("driverId"));
		DeliveryService service = new DeliveryService();
		try {
			service.deleteDelivery(driverId);
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMessage", message);
		
		response.sendRedirect("/techmart-online/getDelivery?action=all");
	}

}
