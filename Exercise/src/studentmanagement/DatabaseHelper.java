package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseHelper {
	public static Connection getConnection() {
		Connection connection = null;
		String url="jdbc:mysql://localhost:3306/studentmanagement";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(url,"root","trandanghieu");
			System.out.println("Connect Successfully!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Can not connect to Driver!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Can not connect to mySQL!");
		} 
		
		
		return connection;
	}
	

}
