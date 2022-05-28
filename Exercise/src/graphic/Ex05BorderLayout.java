package graphic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class Ex05BorderLayout extends JFrame {
	public Ex05BorderLayout() {
		this.setTitle("FlowLayout");
		this.setSize(600, 400);
		// căn giữa cửa sổ chương trình
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// set layout

		BorderLayout borderlayout = new BorderLayout();
		this.setLayout(borderlayout);

		// thêm thành phần

		JButton btnOk = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");

		this.add(btnOk,BorderLayout.NORTH);
		this.add(btnCancel, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Ex05BorderLayout();

	}
}
