package com.atuldwivedi.learnjdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.atuldwivedi.learnjdbc.transaction.SattingAndRollingBackToSavepoints;
import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class SattingAndRollingBackToSavepointsTest {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Connection con = null;
		con = ConnectionFactory.getConnecction();
		
		SattingAndRollingBackToSavepoints obj = new SattingAndRollingBackToSavepoints(con);
		obj.modifyPricesByPercentage("Cappuccino", 5.5f, 20.50f);
	}
}
