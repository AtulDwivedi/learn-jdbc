package com.atuldwivedi.learnjdbc.using.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class CommittingTransactions {
	static Connection con = null;
	static PreparedStatement updateSales = null;
	static PreparedStatement updateTotal = null;

	public static void main(String[] args) {

		try {
			con = ConnectionFactory.getConnecction();
			HashMap<String, Integer> salesForWeek = new HashMap<String, Integer>();
			salesForWeek.put("Cappuccino", new Integer(100));

			updateCoffeeSales(salesForWeek);

			con.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateCoffeeSales(HashMap<String, Integer> salesForWeek)
			throws SQLException {

		String updateString = "update LEARNJDBC_COFFEE "
				+ "set SALES = ? where COF_NAME = ?";

		String updateStatement = "update LEARNJDBC_COFFEE " + "set TOTAL = TOTAL + ? "
				+ "where COF_NAME = ?";

		try {
			con.setAutoCommit(false);
			updateSales = con.prepareStatement(updateString);
			updateTotal = con.prepareStatement(updateStatement);

			for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
				updateSales.setInt(1, e.getValue().intValue());
				updateSales.setString(2, e.getKey());
				updateSales.executeUpdate();
				updateTotal.setInt(1, e.getValue().intValue());
				updateTotal.setString(2, e.getKey());
				updateTotal.executeUpdate();
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					System.err.print("Transaction is being rolled back");
					con.rollback();
				} catch (SQLException excep) {
					excep.printStackTrace();
				}
			}
		} finally {
			if (updateSales != null) {
				updateSales.close();
			}
			if (updateTotal != null) {
				updateTotal.close();
			}
			con.setAutoCommit(true);
		}
	}
}
