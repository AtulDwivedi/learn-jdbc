package com.atuldwivedi.learnjdbc.using.transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SattingAndRollingBackToSavepoints {
	Connection con = null;

	public SattingAndRollingBackToSavepoints(Connection con) {
		super();
		this.con = con;
	}

	public void modifyPricesByPercentage(String coffeeName,
			float priceModifier, float maximumPrice) throws SQLException {

		con.setAutoCommit(false);

		Statement getPrice = null;
		Statement updatePrice = null;
		ResultSet rs = null;
		String query = "SELECT COF_NAME, PRICE FROM COFFEES "
				+ "WHERE COF_NAME = '" + coffeeName + "'";

		try {
			Savepoint save1 = con.setSavepoint();
			getPrice = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			updatePrice = con.createStatement();

			if (!getPrice.execute(query)) {
				System.out.println("Could not find entry "
						+ "for coffee named " + coffeeName);
			} else {
				rs = getPrice.getResultSet();
				rs.first();
				float oldPrice = rs.getFloat("PRICE");
				float newPrice = oldPrice + (oldPrice * priceModifier);
				System.out.println("Old price of " + coffeeName + " is "
						+ oldPrice);

				System.out.println("New price of " + coffeeName + " is "
						+ newPrice);

				System.out.println("Performing update...");

				updatePrice.executeUpdate("UPDATE COFFEES SET PRICE = "
						+ newPrice + " WHERE COF_NAME = '" + coffeeName + "'");

				System.out.println("\nCOFFEES table after " + "update:");

				// CoffeesTable.viewTable(con);

				if (newPrice > maximumPrice) {
					System.out.println("\nThe new price, " + newPrice
							+ ", is greater than the " + "maximum price, "
							+ maximumPrice + ". Rolling back the "
							+ "transaction...");

					con.rollback(save1);

					System.out.println("\nCOFFEES table " + "after rollback:");

					// CoffeesTable.viewTable(con);
				}
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (getPrice != null) {
				getPrice.close();
			}
			if (updatePrice != null) {
				updatePrice.close();
			}
			con.setAutoCommit(true);
		}
	}
}
