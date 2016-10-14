package com.atuldwivedi.learnjdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.atuldwivedi.learnjdbc.util.Cleanup;
import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class ConnectionFactoryTest {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Connection con = ConnectionFactory.getConnecction();
		if (con != null) {
			System.out.println("Connection establised!");
			Cleanup.closeConnection(con);
			System.out.println("Connection closed!");
		} else {
			System.out.println("Failed to connect!");
		}
	}
}
