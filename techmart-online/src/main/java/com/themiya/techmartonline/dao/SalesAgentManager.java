package com.themiya.techmartonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.themiya.techmartonline.model.SalesAgent;

public class SalesAgentManager {
	
	public static SalesAgent getTheSalesAgentBySalesAgentId(int salesAgentId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		
		String query = "SELECT * FROM salesagents WHERE salesAgentId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, salesAgentId);
		
		ResultSet rs = ps.executeQuery();
		
		SalesAgent salesagent = new SalesAgent();
		if(rs.next())
		{
			salesagent.setSalesAgentId(rs.getInt("salesAgentId"));
			salesagent.setSalesAgentName(rs.getString("salesAgentName"));
			salesagent.setSalesAgentBranch(rs.getString("salesAgentBranch"));
			salesagent.setSalesAgentPassword(rs.getString("salesAgentPassword"));
		}
		
		ps.close();
		connection.close();
		return salesagent;
	}
	
	public static List<SalesAgent> getAllSalesAgents() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM salesagents";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<SalesAgent> salesagents = new ArrayList<SalesAgent>();
		
		while(rs.next()) {
			
			SalesAgent salesagent = new SalesAgent(rs.getInt("salesAgentId"), rs.getString("salesAgentName"), rs.getString("salesAgentBranch"), rs.getString("salesAgentPassword"));
			salesagents.add(salesagent);
		}
		
		st.close();
		connection.close();
		return salesagents;
		
		
	}
	
	public static boolean addSalesAgent(SalesAgent salesagent) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO salesagents (salesAgentName, salesAgentBranch, salesAgentPassword) VALUES (?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, salesagent.getSalesAgentName());
		ps.setString(2, salesagent.getSalesAgentBranch());
		ps.setString(3, salesagent.getSalesAgentPassword());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean updateSalesAgent(SalesAgent salesagent) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE salesagents SET salesAgentName=?, salesAgentBranch=?, salesAgentPassword=? WHERE salesAgentId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, salesagent.getSalesAgentName());
		ps.setString(2, salesagent.getSalesAgentBranch());
		ps.setString(3, salesagent.getSalesAgentPassword());
		ps.setInt(4, salesagent.getSalesAgentId());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteSalesAgent(int salesAgentId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM salesagents WHERE salesAgentId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, salesAgentId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}

}
