package com.atuldwivedi.learnjdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class contains very basic example of HelloWorld JDBC program, that
 * fetches all records from a existing table<LEARN_JDBC> and prints the row by row on the console.
 * 
 * This example uses h2 database as data source.
 * 
 * @author Atul Dwivedi 2016
 */
public class HelloWorldJDBC {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Loading the driver class
			Class.forName("org.h2.Driver");
			// Establishing the connection with data source
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			// Creating statement
			stmt = con.createStatement();

			// Performing operation
			rs = stmt.executeQuery("SELECT * FROM LEARN_JDBC");
			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(" ");
				System.out.println(rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
