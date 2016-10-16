package com.atuldwivedi.learnjdbc.basic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atuldwivedi.learnjdbc.util.connection.ConnectionFactory;

public class LearnStoreAndRetrieveFiles {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnecction();
			ps = con.prepareStatement("insert into filetable values(?,?)");

			File f = new File("resources//files//jdbc.txt");
			FileReader fr = new FileReader(f);

			ps.setInt(1, 101);

			ps.setCharacterStream(2, fr, (int) f.length());
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

//			con.close();

			ps = con.prepareStatement("select * from filetable");
			rs = ps.executeQuery();
			rs.next();// now on 1st row

			Clob c = rs.getClob(2);
			Reader r = c.getCharacterStream();

			FileWriter fw = new FileWriter("resources//files//output.txt");

			int j = 0;
			while ((j = r.read()) != -1)
				fw.write((char) j);

			fw.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
