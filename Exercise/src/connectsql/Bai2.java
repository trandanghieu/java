package connectsql;

import java.sql.Connection;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import java.awt.event.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

import java.awt.event.ActionListener;


public class Bai2 extends JFrame implements ActionListener {
	JButton btok, btreset, btexit;
	JLabel l1, l2, l3;
	JTextField url, query;
	JPanel pn1, pn2, pn3, pn4, pn, p5;
	JTable tb;
	private String[] header = { "Id", "Name", "Address", "Total" };
	DefaultTableModel tableModel;
	JScrollPane scroll;

	public void GUI() {
		l1 = new JLabel("Truy Xuat Co So Du Lieu");
		pn1 = new JPanel(new FlowLayout());
		pn1.add(l1);

		l2 = new JLabel("Input Information");
		l3 = new JLabel("SQL");
		url = new JTextField(50);
		url.setHorizontalAlignment(JTextField.CENTER);
		query = new JTextField(50);
		query.setHorizontalAlignment(JTextField.CENTER);
		pn2 = new JPanel(new GridLayout(2, 2));
		pn2.add(l2);
		pn2.add(url);
		pn2.add(l3);
		pn2.add(query);

		tableModel = new DefaultTableModel();

		tb = new JTable();
		tb.setModel(tableModel);
		tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		tb.setFillsViewportHeight(true);
		tableModel.setColumnIdentifiers(header);
		scroll = new JScrollPane(tb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		pn3 = new JPanel();

		pn3.setLayout(new BorderLayout(50, 50));
		pn3.add(scroll, BorderLayout.CENTER);

		btok = new JButton("OK");
		btreset = new JButton("Reset");
		btexit = new JButton("Exit");
		pn4 = new JPanel(new FlowLayout());
		pn4.add(btok);
		pn4.add(btreset);
		pn4.add(btexit);
		p5 = new JPanel(new BorderLayout());
		p5.add(pn4, BorderLayout.SOUTH);
		pn = new JPanel(new GridLayout(4, 1));
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(p5);
		btok.addActionListener(this);
		btreset.addActionListener(this);
		btexit.addActionListener(this);
		add(pn);
		setSize(500, 300);
		show();

	}

	public void actionPerformed(ActionEvent e) {
		String se = "SELECT * FROM data";
		String st = query.getText().toLowerCase();
		if (e.getSource() == btok) {
			if (st.contains("select")) {
				select(query.getText());
			}
			if (st.contains("insert"))

				Insert();
			select(se);

		}
		if (st.contains("delete") || st.contains("update")) {
			Delete();
			select(se);

		}
		if (e.getSource() == btreset) {
			url.setText("");
			query.setText("");
		}
		if (e.getSource() == btexit) {
			System.exit(0);
		}
	}

	public Connection getConnection() {
		String Url = url.getText().toString();

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(Url, "root", "trandanghieu");
		} catch (Exception e) {
			System.err.print("KET NOI THAT BAI");
		}
		return con;
	}

	public void select(String Query) {

		String id = "";

		String name = "";

		String address = "";

		Double total = 0.0;

		try {

			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			ResultSetMetaData rsmd = rs.getMetaData();
			tableModel.setRowCount(0);
			while (rs.next()) {

				id = (rs.getString("id"));
				name = (rs.getString("name"));
				address = (rs.getString("address"));
				total = (rs.getDouble("total"));

				tableModel.addRow(new Object[] { id, name, address, total });
			}
			tb.setModel(tableModel);
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.err.print(" HONG THE KET NOI");
		}

	}

	public void Insert() {
		String Query = query.getText().toString();
		try {

			Connection con = getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(Query);
			con.close();

		} catch (Exception e) {
			System.err.print("ID DA BI TRUNG");
		}

	}

	public void Delete() {
		String Query = query.getText().toString();
		try {

			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.executeUpdate(Query);
			con.close();

		} catch (Exception e) {
			System.err.print(" KHONG THE KET NOI");
		}
	}

	public static void main(String[] args) {
		Bai2 a = new Bai2();
		a.GUI();
	}
}
