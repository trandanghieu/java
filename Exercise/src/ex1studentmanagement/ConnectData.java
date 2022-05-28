package ex1studentmanagement;

import java.awt.dnd.DropTarget;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectData {
	public static Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/exdata";
		String user = "root";
		String password = "trandanghieu";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connect Successfully!");

		} catch (SQLException e) {
			System.out.println("Can't connect to Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can't connect to mySQL");
		}
		return connection;
	}
	// Hàm lấy tất cả sinh viên
	public static List<Student> findAll() {
		List<Student> listStudent = new ArrayList<>();
		String query = " select * from liststudent";
		try {
			Connection connection = getConnection();
			Statement statemnet = connection.createStatement();
			ResultSet rs = statemnet.executeQuery(query);
			while (rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
						rs.getInt("gender"), rs.getString("major"), rs.getFloat("score")

				);
				listStudent.add(student);

			}
		} catch (Exception e) {

		}

		return listStudent;

	}
	public static void insert(Student student) {
		String query="insert into  liststudent(id,name,age,gender,major,score)" + "values(?,?,?,?,?,?)";
		try {
			Connection connection= getConnection();
			// truy vấn có tham số: dùng preparestatement
			PreparedStatement preparestatement= connection.prepareStatement(query);
			preparestatement.setInt(1,student.getId());
			preparestatement.setString(2,student.getName());
			preparestatement.setInt(3, student.getAge());
			preparestatement.setInt(4,student.getGender());
			preparestatement.setString(5, student.getMajor());
			preparestatement.setFloat(6, student.getScore());
			preparestatement.execute();
		} catch (Exception e) {
			
		}
	}
	public static void deleteByName(Student student) {
		String query="delete from liststudent where name= '"+student.getName()+"'";               
		try {
			Connection connection=getConnection();
			PreparedStatement prestatement= connection.prepareStatement(query);
			prestatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
		
	
	public static List<Student> findByName(Student s) {
		List<Student> listStudent1 = new ArrayList<>();
		String query = " select * from liststudent where liststudent.name = '" + s.getName()+"'";
		try {
			Connection connection = getConnection();
			Statement statemnet = connection.createStatement();
			ResultSet rs = statemnet.executeQuery(query);
			while (rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
						rs.getInt("gender"), rs.getString("major"), rs.getFloat("score")

				);
				listStudent1.add(student);

			}
		} catch (Exception e) {

		}

		return listStudent1;
	}
	public static void Update(Student st) {
		String query="update liststudent SET id=?, name=?, age=?, gender=?, major=?, score=? where name=' "+ st.getName()+"'";
		try {
			Connection connection=getConnection();
			PreparedStatement preparedstatement= connection.prepareStatement(query);
			preparedstatement.setInt(1, st.getId());
			preparedstatement.setString(2, st.getName());
			preparedstatement.setInt(3, st.getAge());
			preparedstatement.setInt(4, st.getGender());
			preparedstatement.setString(5, st.getMajor());
			preparedstatement.setFloat(6, st.getScore());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
