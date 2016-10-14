package com.atuldwivedi.learnjdbc.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectionFactory {

	static Connection con;
	static String className;
	static String url;
	static String userName;
	static String passwrod;

	public static Connection getConnecction() throws ClassNotFoundException,
			SQLException {
		if (con == null) {
			ResourceBundle resourceBundle = ResourceBundle.getBundle(
					"com//atuldwivedi//learnjdbc//connection//db", Locale.US);
			Class.forName(resourceBundle.getString("className"));
			con = DriverManager.getConnection(resourceBundle.getString("url"),
					resourceBundle.getString("userName"),
					resourceBundle.getString("password"));
		}
		return con;
	}
}
