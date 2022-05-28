package connectsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * CÁC BƯỚC KẾT NỐI VỚI CƠ SỞ DỮ LIỆU
 * 1. TẠO KẾT NỐI DRIVER
 * 2. XÂY DỰNG 1 URL KẾT NỐI(url,user,password)
 * 3.
 */

public class Ex01SwingSQL {
	public static Connection getConnection() {
		Connection connection = null;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/person";
			String user = "root";
			String password = "trandanghieu";
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}
	public static void main(String[] args) {
		Connection con= getConnection();
		System.out.println(con);
	}

}
