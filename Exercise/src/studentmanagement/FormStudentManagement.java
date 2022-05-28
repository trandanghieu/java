package studentmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormStudentManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaSV;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JTextField txtSDT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormStudentManagement frame = new FormStudentManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormStudentManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 799, 93);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("QU\u1EA2N L\u00CD SINH VI\u00CAN");
		lblNewLabel_6.setFont(new Font("UTM Alberta Heavy", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(241, 10, 475, 63);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 113, 799, 238);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 SV");
		lblNewLabel.setBounds(10, 10, 54, 27);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD t\u00EAn:");
		lblNewLabel_1.setBounds(10, 57, 54, 27);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(10, 99, 54, 27);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblNewLabel_3.setBounds(10, 136, 84, 33);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblNewLabel_4.setBounds(10, 179, 54, 27);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("S\u1ED1 \u0110T:");
		lblNewLabel_5.setBounds(256, 99, 62, 27);
		panel_1.add(lblNewLabel_5);
		
		txtMaSV = new JTextField();
		txtMaSV.setBounds(72, 14, 404, 19);
		panel_1.add(txtMaSV);
		txtMaSV.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(72, 61, 404, 19);
		panel_1.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(72, 103, 142, 19);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(72, 183, 404, 19);
		panel_1.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(328, 103, 148, 19);
		panel_1.add(txtSDT);
		txtSDT.setColumns(10);
		
		JButton btnTimKiem = new JButton("T\u00ECm ki\u1EBFm");
		// SỰ KIỆN TÌM KIẾM THEO MÃ SINH VIÊN
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaSV.getText().equals("")) {
					JOptionPane.showMessageDialog(btnTimKiem, "Mã SV cần phải được nhập để tìm kiếm");
					return;
				}
				try {
					StudentDao dao = new StudentDao();
					
					Student student=dao.findById(txtMaSV.getText());
					if(student!=null) {
						txtHoTen.setText(student.getHoTen());
						txtEmail.setText(student.getEmail());
						txtSDT.setText(student.getSoDT());
						txtDiaChi.setText(student.getDiaChi());
						//rdbtnNam.setSelected(student.getGioiTinh()==1);
						//rdbtnNu.setSelected(student.getGioiTinh()==0);
						
					}
					else {
						JOptionPane.showMessageDialog(btnTimKiem, "Không tìm thấy SV");
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnTimKiem, "Error"+ e2.getMessage());
					e2.printStackTrace();
					
				}
			}
		});
		btnTimKiem.setBounds(629, 55, 85, 21);
		panel_1.add(btnTimKiem);
		
		JButton btnNhapMoi = new JButton("Nh\u1EADp m\u1EDBi");
		// SỰ KIỆN THÊM MỚI(XÓA TRẮNG CÁC TRƯỜNG)
		btnNhapMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaSV.setText("");
				txtHoTen.setText("");
				txtEmail.setText("");
				txtSDT.setText("");
				txtDiaChi.setText("");
			
			}
		});
		btnNhapMoi.setBounds(629, 86, 85, 21);
		panel_1.add(btnNhapMoi);
		
		JButton btnLuu = new JButton("L\u01B0u");
		// SỰ KIỆN LƯU(INSERT)
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder strbuider= new StringBuilder();
				if(txtMaSV.getText().equals("")) {
					strbuider.append("Mã SV không được để trống");
					txtMaSV.setBackground(Color.red);
					
				}
				else {
					txtMaSV.setBackground(Color.white);
				}
				if(strbuider.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, e);
					return;
				}
				try {
					Student student= new Student();
					student.setMaSV(txtMaSV.getText());
					student.setHoTen(txtHoTen.getText());
					student.setEmail(txtEmail.getText());
					student.setSoDT(txtSDT.getText());
					//student.setGioiTinh(rdbtnNam.isSelected()?1:0);
					student.setDiaChi(txtDiaChi.getText());
		
					StudentDao dao= new StudentDao();
					dao.insertData(student);
					JOptionPane.showMessageDialog(btnLuu, "SV Mới đã được lưu vào cơ sở dữ liệu");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error"+ e2.getMessage());
					e2.printStackTrace();
				}
				
			}
		});
		btnLuu.setBounds(629, 117, 85, 21);
		panel_1.add(btnLuu);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		// XỬ LÝ CẬP NHẬT	
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder strbuider= new StringBuilder();
				if(txtMaSV.getText().equals("")) {
					strbuider.append("Mã SV không được để trống");
					txtMaSV.setBackground(Color.red);
					
				}
				else {
					txtMaSV.setBackground(Color.white);
				}
				if(strbuider.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, e);
					return;
				}
				if(JOptionPane.showConfirmDialog(btnCapNhat, "Bạn có muốn Cập nhật SV không?") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					Student student= new Student();
					student.setMaSV(txtMaSV.getText());
					student.setHoTen(txtHoTen.getText());
					student.setEmail(txtEmail.getText());
					student.setSoDT(txtSDT.getText());
					//student.setGioiTinh(rdbtnNam.isSelected()?1:0);
					student.setDiaChi(txtDiaChi.getText());
		
					StudentDao dao= new StudentDao();
					dao.update(student);
					JOptionPane.showMessageDialog(btnLuu, "SV Mới đã được cập nhật vào cơ sở dữ liệu");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error"+ e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		btnCapNhat.setBounds(629, 148, 85, 21);
		panel_1.add(btnCapNhat);
		
		JButton btnXoa = new JButton("X\u00F3a");
		//XÓA
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder strbuider= new StringBuilder();
				if(txtMaSV.getText().equals("")) {
					strbuider.append("Mã SV không được để trống");
					txtMaSV.setBackground(Color.red);
					
				}
				else {
					txtMaSV.setBackground(Color.white);
				}
				if(strbuider.length()>0) {
					JOptionPane.showMessageDialog(btnLuu, e);
					return;
				}
				if(JOptionPane.showConfirmDialog(btnXoa, "Bạn có muốn xóa SV không?") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					
		
					StudentDao dao= new StudentDao();
					dao.deleteById(txtMaSV.getText());
					JOptionPane.showMessageDialog(btnLuu, "Đã xóa SV khỏi cơ sở dữ liệu");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLuu, "Error"+ e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		btnXoa.setBounds(629, 179, 85, 21);
		panel_1.add(btnXoa);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(74, 142, 76, 21);
		panel_1.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("N\u1EEF");
		rdbtnNu.setBounds(152, 142, 103, 21);
		panel_1.add(rdbtnNu);
		
		JButton btnFirst = new JButton("First");
		btnFirst.setBounds(103, 212, 85, 21);
		panel_1.add(btnFirst);
		
		JButton btnPrivious = new JButton("Privious");
		btnPrivious.setBounds(256, 212, 85, 21);
		panel_1.add(btnPrivious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(401, 212, 85, 21);
		panel_1.add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.setBounds(536, 212, 85, 21);
		panel_1.add(btnLast);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 392, 799, 182);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}
}
