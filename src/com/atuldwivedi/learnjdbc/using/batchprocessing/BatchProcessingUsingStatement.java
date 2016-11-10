package com.atuldwivedi.learnjdbc.using.batchprocessing;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class BatchProcessingUsingStatement {

	static Connection con;
	static Statement stmt;

	public static void main(String[] args) {
		try {
			con = ConnectionFactory.getConnecction();
			stmt = con.createStatement();
			stmt.addBatch("insert into learnjdbc_coffee values('Cof1', 0, 0, 10.10)");
			stmt.addBatch("insert into learnjdbc_coffee values('Cof2', 0, 0, 20.10)");
			int[] i = stmt.executeBatch();
			for (int j = 0; j < i.length; j++) {
				System.out.println(i[j]);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
