package com.atuldwivedi.learnjdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LearnResultSet {

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

			// Getting first record
			rs.first();
			System.out.print(rs.getInt(1));
			System.out.print(" ");
			System.out.println(rs.getString(2));

			// Getting the record of particular row
			rs.absolute(2);
			System.out.print(rs.getInt(1));
			System.out.print(" ");
			System.out.println(rs.getString(2));

			// Getting last record
			rs.last();
			System.out.print(rs.getInt(1));
			System.out.print(" ");
			System.out.println(rs.getString(2));

			// Iterating over result set
			while (rs.next()) {
				System.out.print(">>");
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
