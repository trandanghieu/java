package studentmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class StudentDao {
	public boolean insertData(Student student) throws Exception {

		String sql = "insert into student	(masv,hoten,email,sodt,gioitinh,diachi) values( ?,?,?,?,?,?);";
		try (Connection connection = DatabaseHelper.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(sql);) {
			preparestatement.setString(1, student.getMaSV());
			preparestatement.setString(2, student.getHoTen());
			preparestatement.setString(3, student.getEmail());
			preparestatement.setString(4, student.getSoDT());
			preparestatement.setInt(5, student.getGioiTinh());
			preparestatement.setString(6, student.getDiaChi());
			return preparestatement.executeUpdate() > 0;

		}

	}
	public Student findById(String maSV) throws Exception{
		String sql="select * from student where masv=?";
		try(
				Connection connection=DatabaseHelper.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(sql);
				){
			preparestatement.setString(1, maSV);
			ResultSet rs=preparestatement.executeQuery();
			
			if(rs.next()) {
				Student student= new Student();
				student.setMaSV(rs.getString("maSV"));
				student.setHoTen(rs.getString("hoten"));
				student.setEmail(rs.getString("email"));
				student.setSoDT(rs.getString("sodt"));
				student.setGioiTinh(rs.getInt("gioitinh"));
				student.setDiaChi(rs.getString("diachi"));
				return student;
			}
			return null;
			
		}
	}
	public boolean update(Student student) throws SQLException {
		String sql="update student set hoten=?, email=?,sodt=?,gioitinh=?, diachi=?" + " where masv=?";
		try(
				Connection connection=DatabaseHelper.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(sql);
				
				){
			preparestatement.setString(6,student.getMaSV());
			preparestatement.setString(1,student.getHoTen());
			preparestatement.setString(2,student.getEmail());
			preparestatement.setString(3,student.getSoDT());
			preparestatement.setInt(4,student.getGioiTinh());
			preparestatement.setString(5,student.getDiaChi());
			return preparestatement.executeUpdate()>0;
			
		}
	}
	public boolean deleteById(String maSV) throws SQLException {
		String sql="delete from student where masv=?";
		try(
				Connection connection=DatabaseHelper.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(sql);
				
				){
			preparestatement.setString(1,maSV);
			
			return preparestatement.executeUpdate()>0;
			
		}
	}
	
}
