package graphic;

import javax.swing.JFrame;

public class Ex02 extends JFrame {
	public Ex02() {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void showIt() {
		this.setVisible(true);

	}

	public void showTitle(String title) {

		this.setTitle(title);
		this.setVisible(true);
	}

	public void showWindow(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Ex02 o1 = new Ex02();
		Ex02 o2 = new Ex02();
		Ex02 o3 = new Ex02();
		//o1.showIt();
		//o2.showTitle("JFrame");
		o3.showWindow("JFrame", 600, 400);
	}
}
