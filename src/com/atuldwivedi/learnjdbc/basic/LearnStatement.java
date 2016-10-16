package com.atuldwivedi.learnjdbc.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.atuldwivedi.learnjdbc.util.ReleaseResources;
import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

/**
 * This class contains very basic example of JDBC program for using {@link Statement} interface,
 * it creates a table, inserts a record and fetch the same.
 * 
 * This example uses h2 database as data source.
 * 
 * @author Atul Dwivedi 2016
 */
public class LearnStatement {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String createLoginTable = "CREATE TABLE LOGIN (USERNAME VARCHAR2, PASSWORD VARCHAR2)";
		String insertIntoLoginTable = "INSERT INTO LOGIN VALUES('Atul', '1234')";
		String selectFromLoginTable = "SELECT * FROM LOGIN";
		int rowUpdatedRowCount = 0;
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnecction();
			stmt = con.createStatement();

			rowUpdatedRowCount = stmt.executeUpdate(createLoginTable);
			if(rowUpdatedRowCount >= 0){
				System.out.println("Table created successfully.");
				rowUpdatedRowCount = stmt.executeUpdate(insertIntoLoginTable);
				if(rowUpdatedRowCount >= 0){
					System.out.println("Row iserted successfully.");
					rs = stmt.executeQuery(selectFromLoginTable);
					while(rs.next()){
						System.out.println(rs.getString(1));
						System.out.println(rs.getString(2));
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ReleaseResources.closeResultSet(rs);
			ReleaseResources.closeStatement(stmt);
			ReleaseResources.closeConnection(con);
		}
	}
}
