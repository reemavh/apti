package com.ba.apti.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLClient {
	
	public boolean addEntry( String id, String name, String dateOfBirth, String email, 
			String phone, String dbxFileName) {
		String sql= "INSERT INTO BATEST" +
					"(" + 
						"NAME," + 
						"DOB," + 
						"EMAIL," +  
						"PHONENUM," + 
						"DBXFILENAME," +
						"ID" + 
				")VALUES(?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = getPreparedStatement(sql);
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2,dateOfBirth);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, dbxFileName);
			preparedStatement.setString(6, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String getLatestEntries(int n)  {
		String query = "select * from BATEST order by TODAY DESC LIMIT " + n;
		ResultSet results = executeQuery(query);
		StringBuilder resultJson = new StringBuilder();
		resultJson.append("{\"results\":[");
		try {
			if(results.next()) {
				resultJson.append("{");
				resultJson.append("\"id\":\"" + results.getString("ID") + "\",");
				resultJson.append("\"name\":\"" + results.getString("NAME") + "\",");
				resultJson.append("\"email\":\"" + results.getString("EMAIL") + "\",");
				resultJson.append("\"url\":\"" + DropBoxClient.getPublicURL(results.getString("DBXFILENAME")) + "\",");
				resultJson.append("\"date\":\"" + results.getDate("TODAY") + "\",");
				resultJson.append("\"phone\":\"" + results.getString("PHONENUM") + "\"");
				resultJson.append("}");
			}
			while(results.next()) {
				resultJson.append(",{");
				resultJson.append("\"id\":\"" + results.getString("ID") + "\",");
				resultJson.append("\"name\":\"" + results.getString("NAME") + "\",");
				resultJson.append("\"email\":\"" + results.getString("EMAIL") + "\",");
				resultJson.append("\"url\":\"" + DropBoxClient.getPublicURL(results.getString("DBXFILENAME")) + "\",");
				resultJson.append("\"date\":\"" + results.getDate("TODAY") + "\",");
				resultJson.append("\"phone\":\"" + results.getString("PHONENUM") + "\"");
				resultJson.append("}");			
			}
			resultJson.append("]}");
			return resultJson.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
    private static Connection connection;
	private static MySQLClient connector;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL Driver Not Found.");
			e.printStackTrace();
		}
	
		try {
			
			connection = DriverManager.getConnection("jdbc:db2://75.126.155.153:50000/SQLDB","user03385", "oZMKx9XxB6D9");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/batest","root", "passw0rd");			
		} catch ( SQLException e ) {
			System.err.println ( "Connection failed.");
			e.printStackTrace();
		}
	}
		
	private MySQLClient() {
		
	}
	
	public static MySQLClient getConnector() {
		if(connector == null) {
			connector = new MySQLClient();
			return connector;
		}
		return connector;
	}
	

	
	public ResultSet executeQuery(String query) {
		try {
			Statement statement = connection.createStatement();			
			return statement.executeQuery(query);				
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getPreparedStatement(String sql) {
		try {
			return connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	public int executePreparedUpdate(PreparedStatement ps) {
		try {
			return ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
			return 0;
		}
	}*/
	
}
