package com.atuldwivedi.learnjdbc.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atuldwivedi.learnjdbc.util.ReleaseResources;
import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class LearnStoreAndRetrieveImage {
	static Connection con;
	static PreparedStatement ps;
	static FileInputStream fin;
	static ResultSet rs;

	public static void main(String[] args) {
		try {
			con = ConnectionFactory.getConnecction();

			ps = con.prepareStatement("INSERT INTO PROFILE VALUES(?,?)");
			ps.setString(1, "Penguins");
			fin = new FileInputStream("resources//images//Penguins.jpg");
			ps.setBinaryStream(2, fin, fin.available());

			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM PROFILE");
			rs = ps.executeQuery();
			if (rs.next()) {

				Blob b = rs.getBlob(2);
				byte barr[] = b.getBytes(1, (int) b.length());

				FileOutputStream fout = new FileOutputStream(
						"resources//images//output.jpg");
				fout.write(barr);

				fout.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ReleaseResources.closePreparedStatement(ps);
			ReleaseResources.closeResultSet(rs);
			ReleaseResources.closeConnection(con);
		}
	}
}
