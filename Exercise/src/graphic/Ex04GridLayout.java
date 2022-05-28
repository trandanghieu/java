package graphic;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex04GridLayout extends JFrame {
	public Ex04GridLayout() {
		this.setTitle("FlowLayout");
		this.setSize(600, 400);
		// căn giữa cửa sổ chương trình
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// set layout

		GridLayout gridlayout1=new GridLayout();
		GridLayout gridlayout2=new GridLayout(4,4);
		GridLayout gridlayout3=new GridLayout(4,4,25,25);
		
		this.setLayout(gridlayout3);

		// thêm thành phần

		JButton btnOk = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");

		this.add(btnOk);
		this.add(btnCancel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Ex04GridLayout();

	}
}
