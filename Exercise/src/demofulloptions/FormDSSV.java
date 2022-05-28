package demofulloptions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class FormDSSV extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable jTableSinhVien;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDSSV frame = new FormDSSV();
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
	public FormDSSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u1EEB kh\u00F3a:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(60, 56, 59, 30);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(146, 63, 243, 23);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(449, 62, 91, 23);
		contentPane.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 124, 584, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 564, 172);
		panel.add(scrollPane);
		
		jTableSinhVien = new JTable();
		scrollPane.setViewportView(jTableSinhVien);
		jTableSinhVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[]  {
				"MSSV", "HoTen", "Dien Thoai", "Email", "Dia Chi"
			}
		));
	}

}
