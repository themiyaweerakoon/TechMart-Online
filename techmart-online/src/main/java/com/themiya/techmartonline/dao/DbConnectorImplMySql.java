package com.themiya.techmartonline.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectorImplMySql implements DbConnector {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/techmart_online";
		String userName = "root";
		String password = "12345678";
		return  DriverManager.getConnection(url, userName, password);
		
		
	}

}
