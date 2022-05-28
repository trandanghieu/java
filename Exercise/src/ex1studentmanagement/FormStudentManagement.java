package ex1studentmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormStudentManagement extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtMajor;
	private JTextField txtScore;
	private JTextField txtId;

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
		setBounds(100, 100, 817, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 783, 227);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 48, 45, 13);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("AGE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(22, 80, 45, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("GENDER");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(22, 112, 45, 13);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("MAJOR");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(22, 151, 45, 13);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("SCORE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(22, 191, 45, 13);
		panel.add(lblNewLabel_4);

		txtName = new JTextField();
		txtName.setBounds(130, 42, 298, 19);
		panel.add(txtName);
		txtName.setColumns(10);

		txtAge = new JTextField();
		txtAge.setBounds(130, 78, 298, 19);
		panel.add(txtAge);
		txtAge.setColumns(10);

		txtMajor = new JTextField();
		txtMajor.setColumns(10);
		txtMajor.setBounds(130, 149, 298, 19);
		panel.add(txtMajor);

		txtScore = new JTextField();
		txtScore.setColumns(10);
		txtScore.setBounds(130, 189, 298, 19);
		panel.add(txtScore);

		JComboBox cbbGender = new JComboBox();
		cbbGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbbGender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		cbbGender.setBounds(130, 109, 298, 21);
		panel.add(cbbGender);

		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtName.setText("");
				txtAge.setText("");
				txtMajor.setText("");
				txtScore.setText("");
			
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRefresh.setBounds(497, 7, 96, 21);
		panel.add(btnRefresh);
		// DELETE
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student= new Student();
				student.setName(txtName.getText());
				ConnectData.deleteByName(student);
				showData(ConnectData.findAll());
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(497, 76, 96, 21);
		panel.add(btnDelete);

		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student= new Student();
				student.setName(txtName.getText());
				//List<Student> listStudent = new ArrayList<>();
				showData(ConnectData.findByName(student));
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFind.setBounds(497, 108, 96, 21);
		panel.add(btnFind);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(22, 12, 45, 13);
		panel.add(lblNewLabel_5);
		
		txtId = new JTextField();
		txtId.setBounds(130, 13, 298, 19);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = new Student();
				student.setId(Integer.parseInt(txtId.getText()));
				student.setName(txtName.getText());
				student.setAge(Integer.parseInt(txtAge.getText()));
				student.setGender(cbbGender.getSelectedIndex());
				student.setMajor(txtMajor.getText());
				student.setScore(Float.parseFloat(txtScore.getText()));
				ConnectData.insert(student);
				JOptionPane.showMessageDialog(btnSave, "Save Successfully");
				showData(ConnectData.findAll());
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(497, 44, 96, 17);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st= new Student();
				st.setId(Integer.parseInt(txtId.getText()));
				st.setName(txtName.getText());
				st.setAge(Integer.parseInt(txtAge.getText()));
				st.setGender(cbbGender.getSelectedIndex());
				st.setMajor(txtMajor.getText());
				st.setScore(Float.parseFloat(txtScore.getText()));
				ConnectData.Update(st);
				JOptionPane.showMessageDialog(btnSave, "Update Successfully");
				showData(ConnectData.findAll());
				
				
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(497, 148, 96, 20);
		panel.add(btnUpdate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 247, 783, 190);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "ID", "Name", "AGE", "Gender", "Major", "Score" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(33);
		table.getColumnModel().getColumn(1).setPreferredWidth(128);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(56);
		table.getColumnModel().getColumn(4).setPreferredWidth(135);
		scrollPane.setViewportView(table);
		showData(ConnectData.findAll());
	}

	public void showData(List<Student> listStudent1) {

		List<Student> listStudent = new ArrayList<>();
		listStudent = listStudent1;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		listStudent.forEach((student) -> {
			String gender;
			if (student.getGender() == 0) {
				gender = "Male";
			} else {
				gender = "Female";
			}
			tableModel.addRow(new Object[] {
					student.getId(),
					student.getName(),
					student.getAge(),
					gender,
					student.getMajor(),
					student.getScore()

			});

		});

	}
}
