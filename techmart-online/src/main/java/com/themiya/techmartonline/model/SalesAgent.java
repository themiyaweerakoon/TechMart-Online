package com.themiya.techmartonline.model;

public class SalesAgent {
	
	private int salesAgentId;
	private String salesAgentName;
	private String salesAgentBranch;
	private String salesAgentPassword;
	
	public SalesAgent() {

	}

	public SalesAgent(String salesAgentName, String salesAgentBranch, String salesAgentPassword) {
		super();
		this.salesAgentName = salesAgentName;
		this.salesAgentBranch = salesAgentBranch;
		this.salesAgentPassword = salesAgentPassword;
	}

	public SalesAgent(int salesAgentId, String salesAgentName, String salesAgentBranch, String salesAgentPassword) {
		super();
		this.salesAgentId = salesAgentId;
		this.salesAgentName = salesAgentName;
		this.salesAgentBranch = salesAgentBranch;
		this.salesAgentPassword = salesAgentPassword;

	}

	public int getSalesAgentId() {
		return salesAgentId;
	}

	public void setSalesAgentId(int salesAgentId) {
		this.salesAgentId = salesAgentId;
	}

	public String getSalesAgentName() {
		return salesAgentName;
	}

	public void setSalesAgentName(String salesAgentName) {
		this.salesAgentName = salesAgentName;
	}

	public String getSalesAgentBranch() {
		return salesAgentBranch;
	}

	public void setSalesAgentBranch(String salesAgentBranch) {
		this.salesAgentBranch = salesAgentBranch;
	}

	public String getSalesAgentPassword() {
		return salesAgentPassword;
	}

	public void setSalesAgentPassword(String salesAgentPassword) {
		this.salesAgentPassword = salesAgentPassword;
	}
	
}
