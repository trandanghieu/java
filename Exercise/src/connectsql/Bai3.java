package connectsql;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Bai3 extends JFrame implements ActionListener,ItemListener{

	JLabel lb1,lb2,lb3;
	JTextField t1;
	JButton b1,b2,b3;
	CheckboxGroup c;
	Checkbox c1,c2,c3,c4,c5;

	JTable tb;
	private String[] header = {"id", "name", "address" ,"total"};
	DefaultTableModel tableModel;
	JScrollPane scroll;
	JPanel p1,p2,p3,p4,p,p5,p6,p7,p8;
	private static String query1="";

	public void GUI() {
		lb1 = new JLabel("TIM KIEM THONG TIN");
		p1 =new JPanel(new FlowLayout());
		p1.add(lb1);


		lb2 = new JLabel("INPUT");
		t1 = new JTextField(22);
		b1 = new JButton("Search");
		b2 = new JButton("Reset");
		b3 = new JButton("Exit");


		p2 = new JPanel(new FlowLayout());
		p2.add(lb2,BorderLayout.WEST);
		p2.add(t1);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);




		lb3 = new JLabel("SearchAs");
		c = new CheckboxGroup();
		c1 =new Checkbox("Id",c,false);
		c2 =new Checkbox("Name",c,false);
		c3 =new Checkbox("Address",c,false);
		c4=new Checkbox("Total",c,false);
		c5 = new Checkbox("HUY");
		p3 = new JPanel(new GridLayout(1,5));
		p3.add(lb3);
		p3.add(c1);
		p3.add(c2);
		p3.add(c3);
		p3.add(c4);


		tableModel = new DefaultTableModel();
		tb = new JTable();
		tb.setModel(tableModel);
		tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tb.setFillsViewportHeight(true);
		tableModel.setColumnIdentifiers(header);
		scroll = new JScrollPane(tb);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		p4 = new JPanel(new FlowLayout());
		p4.add(scroll);

		p = new JPanel( new GridLayout(4,1));
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);

		add(p);
		setSize(500,300);
		show();
	}

	public void itemStateChanged(ItemEvent e) {

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() ==b1) {
			if(c1.getState()==true) {
				query1="SELECT * FROM data where id ='"+t1.getText()+"'";
				Show(query1 );
			}
			else if(c2.getState()==true) {
				query1="SELECT * FROM data where name like'%"+t1.getText()+"%'";
				Show(query1 );
			}
			else  if(c3.getState()==true) {
				query1="SELECT * FROM data where address like'%"+t1.getText()+"%'";
				Show(query1 );
			}
			else if(c4.getState()==true) {
				query1="SELECT * FROM data where total ="+Double.parseDouble(t1.getText());
				Show(query1 );
			}



		}
		if(e.getSource()==b2) {
			t1.setText("");
			tableModel.setRowCount(0);

		}
		if(e.getSource()==b3) {
			System.exit(0);
		}
	}
	public  void Show(String q) {
		String id = "";

		String name = "";

		String address = "";

		Double total =0.0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","trandanghieu");
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery(q);
			ResultSetMetaData rsmd = rs.getMetaData();	
			while(rs.next()) {

				id=(rs.getString("id"));
				name=(rs.getString("name"));
				address=(rs.getString("address"));
				total=(rs.getDouble("total"));


				tableModel.addRow(new Object[] {id,name,address,total});
			}
			tb.setModel(tableModel);
			rs.close();
			stmt.close();
		}catch (Exception e) {
			System.err.print("Khong ket noi dc");
		}

	}

	public static void main(String[] args) {
		Bai3 a = new Bai3();
		a.GUI();
	}
}
