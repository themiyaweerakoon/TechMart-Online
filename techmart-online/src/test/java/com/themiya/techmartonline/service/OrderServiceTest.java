package com.themiya.techmartonline.service;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;


@TestInstance(Lifecycle.PER_CLASS)
class OrderServiceTest {
	
	public OrderServiceTest() {
		System.out.println("instance got created");
	}
	
	@BeforeAll
	public void beforeAll() {
		System.out.println("Before all extecuted ===");
	}
	
	@AfterAll
	public void afterAll() {
		System.out.println("After all extecuted ===");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("=== Before each method extecuted");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("=== After each method extecuted");
	}

	
	@Test
	@DisplayName("When testing the search method")
	@EnabledOnOs(OS.WINDOWS)
	@EnabledOnJre(JRE.JAVA_14)
	void testGetSpecificOrderByOrderId() throws ClassNotFoundException, SQLException {

		OrderService orderService = new OrderService();
		orderService.getSpecificOrderByOrderId(4);
		Assertions.assertTrue(orderService.getAllOrders().isEmpty());
		Assertions.assertEquals(0,orderService.getAllOrders().size());

	}


	@Test
	void testAddOrder() {

		
	}

	@Test
	void testUpdateOrder() {

		
	}

	@Test
	@DisplayName("When testing the delete method")
	void testDeleteOrder() throws ClassNotFoundException, SQLException {

		OrderService orderService = new OrderService();
		orderService.deleteOrder(4);
		Assertions.assertFalse(orderService.getAllOrders().isEmpty());
		Assertions.assertEquals(3,orderService.getAllOrders().size());

	}
}
