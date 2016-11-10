package com.atuldwivedi.learnjdbc.using.batchprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class BatchProcessingUsingPreparedStatement {

	static Connection con;
	static PreparedStatement pstmt;

	public static void main(String[] args) {
		try {
			con = ConnectionFactory.getConnecction();
			pstmt = con
					.prepareStatement("insert into learnjdbc_coffee values(?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			while (true) {
				System.out.println("Enter coffee name: ");
				pstmt.setString(1, br.readLine());

				pstmt.setInt(2, 0);
				pstmt.setInt(3, 0);

				System.out.println("Enter coffee price: ");
				pstmt.setFloat(4, Float.parseFloat(br.readLine()));
				pstmt.addBatch();

				System.out.println("Do you want to continue? (y/n) ");
				if (br.readLine().equals("n"))
					break;
			}

			int[] i = pstmt.executeBatch();
			for (int j = 0; j < i.length; j++) {
				System.out.println(i[j]);
			}

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
