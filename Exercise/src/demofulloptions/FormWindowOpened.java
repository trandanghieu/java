package demofulloptions;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import loaddata.FormStudent;
import demofulloptions.FormDSSV;

public class FormWindowOpened {
	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		// Gọi hàm hiển thị danh sách khi form mở
		hienThiDanhSachSinhVien();
	}

	public static void hienThiDanhSachSinhVien() {
		// Khai báo 1 đối tượng thuộc lớp SinhVienBusiness
		StudentBusiness sinhVienBusiness = new StudentBusiness();

		// Lấy danh sách sinh viên từ db của mysql
		List<Student> list = sinhVienBusiness.getList();
		// Khai báo các cột tiêu đề trên jtable
		String colTieuDe[] = new String[] { "Mã SV", "Họ tên", "Điện thoại", "Email", "Địa chỉ" };

		// Khai báo 1 đối tượng để đưa dữ liệu vào jtable
		DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);

		Object[] row;
		for (Student sv : list) {
			row = new Object[5];
			row[0] = sv.getMaSV();
			row[1] = sv.getHoTen();
			row[2] = sv.getDienThoai();
			row[3] = sv.getEmail();
			row[4] = sv.getDiaChi();
			// Thêm vào model
			model.addRow(row);
		}
		// Hiển thị vào jTable
		jTableSinhVien.setModel(model);

	}

}
