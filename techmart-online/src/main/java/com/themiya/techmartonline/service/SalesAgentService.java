package com.themiya.techmartonline.service;

import java.sql.SQLException;
import java.util.List;

import com.themiya.techmartonline.dao.SalesAgentManager;
import com.themiya.techmartonline.model.SalesAgent;

public class SalesAgentService {
	
	public SalesAgent getSpecificSalesAgentBySalesAgentId(int salesAgentId) throws ClassNotFoundException, SQLException {
		
		return SalesAgentManager.getTheSalesAgentBySalesAgentId(salesAgentId);
	}
	
	public List<SalesAgent> getAllSalesAgents() throws ClassNotFoundException, SQLException {
		
		return SalesAgentManager.getAllSalesAgents();
	}
	
	public boolean addSalesAgent(SalesAgent salesagent) throws ClassNotFoundException, SQLException {
		
		return SalesAgentManager.addSalesAgent(salesagent);
	}
	
	public boolean updateSalesAgent(SalesAgent salesagent) throws ClassNotFoundException, SQLException {
		
		return SalesAgentManager.updateSalesAgent(salesagent);
	}
	
	public boolean deleteSalesAgent(int salesAgentId) throws ClassNotFoundException, SQLException {
		
		return SalesAgentManager.deleteSalesAgent(salesAgentId);
	}

}