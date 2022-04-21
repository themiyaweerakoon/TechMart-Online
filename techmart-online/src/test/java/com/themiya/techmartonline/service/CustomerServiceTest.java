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
class CustomerServiceTest {	
	
	
	public CustomerServiceTest() {
		System.out.println("Instance got created");
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
	void testGetSpecificCustomerByCustomerEmail() throws ClassNotFoundException, SQLException {

		CustomerService customerService = new CustomerService();
		customerService.getSpecificCustomerByCustomerEmail("kasun.ac@gmail.com");
		Assertions.assertTrue(customerService.getAllCustomers().isEmpty());
		Assertions.assertEquals(0,customerService.getAllCustomers().size());

	}
	
	@Test
	void testAddCustomer() {
		
	}

	@Test
	void testUpdateCustomer() {
		
	}
	
	
	@Test
	@DisplayName("When testing the delete method")
	void testDeleteCustomer() throws ClassNotFoundException, SQLException {

		CustomerService customerService = new CustomerService();
		customerService.deleteCustomer("kasun.ac@gmail.com");
		Assertions.assertTrue(customerService.getAllCustomers().isEmpty());
		Assertions.assertEquals(0,customerService.getAllCustomers().size());

	}
		
}

