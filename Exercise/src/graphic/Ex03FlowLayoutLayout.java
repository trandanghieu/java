package graphic;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex03FlowLayoutLayout extends JFrame {
	public Ex03FlowLayoutLayout() {
		this.setTitle("FlowLayout");
		this.setSize(600, 400);
		// căn giữa cửa sổ chương trình
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// set layout

		FlowLayout flowlayout = new FlowLayout();
		this.setLayout(flowlayout);

		// thêm thành phần

		JButton btnOk = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");

		this.add(btnOk);
		this.add(btnCancel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Ex03FlowLayoutLayout();

	}
}
