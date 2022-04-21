package com.themiya.techmartonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalesAgentLoginManager {
	
	public static boolean validate(int salesAgentId,String salesAgentPassword){  
		
		boolean status = false;  
		
		try{  
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
			 
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM salesagents WHERE salesAgentId=? and salesAgentPassword=?");  
		
		ps.setInt(1,salesAgentId);  
		ps.setString(2,salesAgentPassword);  
		      
		ResultSet rs = ps.executeQuery();  
		status = rs.next();  
		          
		}
		
		catch(Exception e){System.out.println(e);}  
		return status;  
		} 

}
