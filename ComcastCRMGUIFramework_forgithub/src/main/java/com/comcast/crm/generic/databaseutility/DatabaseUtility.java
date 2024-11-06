package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	// declare globally bcz in any another method i can close the connection
	   Connection conn=null;

	public void getDbconnection(String url, String username, String password) throws Throwable {
		// what if connection not happening so try
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
	}

	// since we have only one db
	public void getDbconnection() throws Throwable {
		// what if connection not happening so try
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projects", "root", "root");
		} catch (Exception e) {
		}
	}

	public void closeDbconnection() throws Throwable {
		try {
			conn.close();
		} catch (Exception e) {

		}
	}

	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result = null;
		try {
			Statement stmt = conn.createStatement();

			result = stmt.executeQuery(query);
		} catch (Exception e) {

		}
		return result;
	}

	public int executeNonselectQuery(String query) throws SQLException {
		int result = 0;
		try {
			Statement stmt = conn.createStatement();

			result = stmt.executeUpdate(query);
		} catch (Exception e) {

		}
		return result;
	}

}
