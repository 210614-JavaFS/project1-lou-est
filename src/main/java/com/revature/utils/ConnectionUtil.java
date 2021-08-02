package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		
		// Yes they should be in this schema. jdbc:postgresql://java-react-210614.cbrye0xlxa7y.us-east-2.rds.amazonaws.com:5432/project1
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url ="jdbc:postgresql://java-react-210614.cbrye0xlxa7y.us-east-2.rds.amazonaws.com:5432/project1";
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
	}
	
	
}