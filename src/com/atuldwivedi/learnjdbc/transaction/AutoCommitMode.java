package com.atuldwivedi.learnjdbc.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class AutoCommitMode {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			con = ConnectionFactory.getConnecction();
			// disabling auto commit
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int i = stmt.executeUpdate("INSERT INTO LOGIN VALUES('Atul', '12345')");
			// committing the transaction explicitly
			con.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
