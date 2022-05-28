package connectsql;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			// Đăng kí MYSQL Driver với DriverManger
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/person";
			String user = "root";
			String password = "trandanghieu";
			// Tạo kết nối
			c = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	public static void printInfomation(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData mtdt = (DatabaseMetaData) c.getMetaData();

				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {

				c.close();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Connection connection = JDBCUtil.getConnection();
		JDBCUtil.printInfomation(connection);
		JDBCUtil.closeConnection(connection);
		

	}
}
