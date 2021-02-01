package com.leiskies.app.shelter.util.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectionManager { 
	public static Connection sqlConnection = null;
	//private ConnectionManager() {}
	private static final String URL = "jdbc:mysql://localhost:3306/shelter ";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "11teddy11";
	
	public static Connection getConnection() {
		//Properties properties = new Properties();
		//File file = new File("resources/config.properties");
		//InputStream inputStream;
		try {
			//inputStream = new FileInputStream(file);
			//properties.load(inputStream);
			Class.forName("com.mysql.cj.jdbc.Driver");
			sqlConnection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
					//(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}	catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return sqlConnection;
		
    }
 
	public static boolean testConnection() {
		boolean connected = false;
		Statement statement = null;
		ResultSet resultSet = null;
		Set<String> expectedTables = new HashSet<String>(Arrays.asList(new String[] {"user", "animal", "location"}));
		List<String> tableNames = new ArrayList<String>();
		try {
			sqlConnection = ConnectionManager.getConnection();
			statement = sqlConnection.createStatement();
			resultSet =  statement.executeQuery("show tables");
			while(resultSet.next()) {
				tableNames.add(resultSet.getString(1));
			}
			Set<String> actualTables = new HashSet<String>(tableNames);
			if(actualTables.containsAll(expectedTables)) {
				System.out.println("Connection was succesful!\n");
				System.out.println("Inside Database containing the following tables:");
				for(String table: actualTables) {
					System.out.println(table);
				}	System.out.println();
			}	
			
		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}	finally {
			try {
				resultSet.close();
				statement.close();
				sqlConnection.close();
				if(sqlConnection.isClosed()) {
					System.out.println("Connection is now closed!");
				}	return !connected;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	return connected;
	}
}