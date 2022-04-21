package com.themiya.techmartonline.model;

public class Customer {
		
		private String customerEmail;
		private String customerName;
		private String customerAddress;
		private String customerPassword;
		private String customerBranch;
		private String customerPaymentMethod;
		
		public Customer() {

		}

		public Customer(String customerName, String customerAddress, String customerPassword, String customerBranch, String customerPaymentMethod) {
			super();
			this.customerName = customerName;
			this.customerAddress = customerAddress;
			this.customerPassword = customerPassword;
			this.customerBranch = customerBranch;
			this.customerPaymentMethod = customerPaymentMethod;
		}

		public Customer(String customerEmail, String customerName, String customerAddress, String customerPassword, String customerBranch, String customerPaymentMethod) {
			super();
			this.customerEmail = customerEmail;
			this.customerName = customerName;
			this.customerAddress = customerAddress;
			this.customerPassword = customerPassword;
			this.customerBranch = customerBranch;
			this.customerPaymentMethod = customerPaymentMethod;
		}

		public String getCustomerEmail() {
			return customerEmail;
		}

		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerAddress() {
			return customerAddress;
		}

		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}

		public String getCustomerPassword() {
			return customerPassword;
		}

		public void setCustomerPassword(String customerPassword) {
			this.customerPassword = customerPassword;
		}

		public String getCustomerBranch() {
			return customerBranch;
		}

		public void setCustomerBranch(String customerBranch) {
			this.customerBranch = customerBranch;
		}

		public String getCustomerPaymentMethod() {
			return customerPaymentMethod;
		}

		public void setCustomerPaymentMethod(String customerPaymentMethod) {
			this.customerPaymentMethod = customerPaymentMethod;
		}

		
		

}
