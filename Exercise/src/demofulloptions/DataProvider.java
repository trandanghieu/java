package demofulloptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataProvider {
	private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/datastudent";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(url, "root", "trandanghieu");
			System.out.println("Connect Succesfully!");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("Can not find diver.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Can not connect to sqlserver.");
		}
		return connection;
	}
}
