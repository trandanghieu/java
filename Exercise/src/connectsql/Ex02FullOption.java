package connectsql;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Ex02FullOption extends JFrame implements ActionListener {
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnExit;
	private JButton btnRefresh;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtPass;
	private JLabel labName;
	private JLabel labPhone;
	private JLabel labEmail;
	private JLabel labPass;
	private JTable tabledata;
	private JPanel panelTop;
	private JPanel panelDown;
	private JPanel panelLeft;
	private JPanel panelRight;

	public void GUI() {
		this.setTitle("STUDENT MANAGER");
		this.setLocationRelativeTo(null);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnSave = new JButton("SAVE");
		btnExit = new JButton("EXIT");
		btnRefresh = new JButton("REFRESH");
		btnDelete = new JButton("DELETE");

		labName = new JLabel("Full Name:");
		labEmail = new JLabel("Email:");
		labPass = new JLabel("Password:");
		labPhone = new JLabel("Phone number:");

		txtName = new JTextField();
		txtEmail = new JTextField();
		txtPass = new JTextField();
		txtPhone = new JTextField();

		BorderLayout borderlayout1 = new BorderLayout();
		this.setLayout(borderlayout1);

		this.add(panelTop, borderlayout1.NORTH);
		this.add(panelDown, borderlayout1.SOUTH);

		FlowLayout flowlayout1 = new FlowLayout();
		this.setVisible(true);

		show();

	}

	public static Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/demo";
			String user = "root";
			String password = "trandanghieu";
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connect Succesfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Ex02FullOption ex = new Ex02FullOption();
		ex.GUI();

	}

}
