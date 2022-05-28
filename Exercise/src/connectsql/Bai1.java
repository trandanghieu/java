package connectsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Bai1 {
	public static void main(String args[]) {
		System.out.println("KET NOI CO SO DU LIEU");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "trandanghieu");

			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM data";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int socot = rsmd.getColumnCount();
			for (int j = 1; j <= socot; j++) {
				System.out.print(rsmd.getColumnLabel(j) + " ");
			}
			System.out.println("\n");
			while (rs.next()) {
				for (int i = 1; i <= socot; i++) {
					System.out.print(rs.getObject(i) + " ");
				}
				System.out.print("\n");
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			System.err.println(e);
			
		}
	}
}