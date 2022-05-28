package graphic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DemoView extends JFrame implements ActionListener {
	JLabel labName, labPhone, labEmail, labPass;
	JTextField txtName, txtPhone, txtEmail, txtPass;
	JButton btnSave, btnDelete, btnExit, btnRefresh;
	JPanel panel, panelTop, panelDown, panelLeft, panelRight, panelLayerLeft1, panelLayerLeft2, panelLayerLeft3,
			panelLayerRight1, panelLayerRight2, panelLayerRight3;
	JTable table;
	private String[] header = { "Name", "Email", "Phone Number", "Password" };
	DefaultTableModel tableModel;
	JScrollPane scroll;

	public void GUI() {
		this.setTitle("Account Manager");// gán title
		this.setSize(700, 500);// gán size
		this.setLocationRelativeTo(null);// gán vị trí hiển thị tab ở giữa màn hình

		labName = new JLabel("Full Name:");
		labEmail = new JLabel("Email:");
		labPass = new JLabel("Password:");
		labPhone = new JLabel("Phone number:");

		txtName = new JTextField(10);
		txtEmail = new JTextField(10);
		txtPhone = new JTextField(10);
		txtPass = new JTextField(10);

		btnSave = new JButton("ADD");
		btnDelete = new JButton("DELETE");
		btnExit = new JButton("EXIT");
		btnRefresh = new JButton("REFRESH");

		// KHỞI TẠO TABLE

		tableModel = new DefaultTableModel();
		table = new JTable();
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		tableModel.setColumnIdentifiers(header);
		scroll = new JScrollPane(table);

		panel = new JPanel(new GridLayout(2, 1));
		panelTop = new JPanel(new GridLayout(1, 2));
		panelDown = new JPanel(new BorderLayout());
		panelLeft = new JPanel(new GridLayout(3, 1));
		panelRight = new JPanel(new GridLayout(3, 1));

		panelLayerLeft1 = new JPanel(new FlowLayout());
		panelLayerLeft2 = new JPanel(new FlowLayout());
		panelLayerLeft3 = new JPanel(new FlowLayout());

		panelLayerRight1 = new JPanel(new FlowLayout());
		panelLayerRight2 = new JPanel(new FlowLayout());
		panelLayerRight3 = new JPanel(new FlowLayout());

		panelLayerLeft1.add(labName);
		panelLayerLeft1.add(txtName);
		panelLayerLeft2.add(labPhone);
		panelLayerLeft2.add(txtPhone);
		panelLayerLeft3.add(btnSave);
		panelLayerLeft3.add(btnDelete);

		panelLayerRight1.add(labEmail);
		panelLayerRight1.add(txtEmail);
		panelLayerRight2.add(labPass);
		panelLayerRight2.add(txtPass);
		panelLayerRight3.add(btnRefresh);
		panelLayerRight3.add(btnExit);

		panelDown.add(scroll);

		panel.add(panelTop);
		panel.add(panelDown);

		panelTop.add(panelLeft);
		panelTop.add(panelRight);

		panelLeft.add(panelLayerLeft1);
		panelLeft.add(panelLayerLeft2);
		panelLeft.add(panelLayerLeft3);

		panelRight.add(panelLayerRight1);
		panelRight.add(panelLayerRight2);
		panelRight.add(panelLayerRight3);

		add(panel);
		this.setVisible(true);

		show();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static Connection getConnection(String url, String user, String password) {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connect Successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connect Fail!");
		}

		return connection;
	}

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/accountmanager";
		String user = "root";
		String password = "trandanghieu";
		DemoView dm = new DemoView();
		dm.GUI();
		dm.getConnection(url, user, password);

	}

}
