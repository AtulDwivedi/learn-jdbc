package com.atuldwivedi.learnjdbc.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.atuldwivedi.learnjdbc.util.ReleaseResources;
import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class LearnPreparedStatement {
	static Connection con;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			con = ConnectionFactory.getConnecction();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO LOGIN VALUES(?, ?)");

			do {
				System.out.print("enter user name:");
				String username = br.readLine();
				System.out.print("enter password:");
				String password = br.readLine();
				stmt.setString(1, username);
				stmt.setString(2, password);

				int numberOfRecords = stmt.executeUpdate();
				System.out.println(numberOfRecords
						+ " record(s) has been updated!");

				System.out.println("Do you want to continue: y/n");
				String s = br.readLine();
				if (s.startsWith("n")) {
					break;
				}
			} while (true);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ReleaseResources.closeConnection(con);
		}

	}
}
