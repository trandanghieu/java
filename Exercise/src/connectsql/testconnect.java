package connectsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testconnect {
public static void main(String[] args) throws SQLException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/demo";
		String user="root";
		String password="trandanghieu";
		Connection connection=(Connection) DriverManager.getConnection(url, user, password);
		System.out.println("Thanh Cong");
	}catch (ClassNotFoundException e) {
		System.out.println("That Bai");
		e.printStackTrace();
	}
}
}
