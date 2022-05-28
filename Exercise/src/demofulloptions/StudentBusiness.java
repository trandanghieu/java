package demofulloptions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentBusiness {

	public List<Student> getList() {
		List<Student> list = new ArrayList();
		Connection connection = null;

		try {
			connection = DataProvider.getConnection();
			String strSQL = "Select MaSV, HoTen, DienThoai, Email, DiaChi, MaKhoa" + " from SinhVien";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(strSQL);

			Student objSV = null;
			// Đọc từng dòng thông tin
			while (rs.next()) {
				// Khởi tạo đối tượng
				objSV = new Student();
				// Gán giá trị cho các thuộc tính
				objSV.setMaSV(rs.getString("MaSV"));
				objSV.setHoTen(rs.getString("HoTen"));
				objSV.setDienThoai(rs.getString("DienThoai"));
				objSV.setEmail(rs.getString("Email"));
				objSV.setMaKhoa(rs.getString("MaKhoa"));
				// Thêm vào danh sách
				list.add(objSV);
			}
		} catch (SQLException e) {
			System.out.println("Error");

		} finally {
			try {
				// Đóng kết nối
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				System.out.println("Error");
			}
		}

		return list;
	}

}
