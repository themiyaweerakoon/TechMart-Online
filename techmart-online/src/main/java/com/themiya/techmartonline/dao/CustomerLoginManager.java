package com.themiya.techmartonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginManager {
	
	public static boolean validate(String customerEmail,String customerPassword){  
		
		boolean status = false;  
		
		try{  
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
			 
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM customers WHERE customerEmail=? and customerPassword=?");  
		
		ps.setString(1,customerEmail);  
		ps.setString(2,customerPassword);  
		      
		ResultSet rs = ps.executeQuery();  
		status = rs.next();  
		          
		}
		
		catch(Exception e){System.out.println(e);}  
		return status;  
		}  
	}  

