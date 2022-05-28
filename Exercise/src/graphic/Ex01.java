package graphic;

import javax.swing.JFrame;

public class Ex01 {
	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setTitle("JFrame");// tạo title
		jf.setSize(600,400);// set size cho cửa sổ
		jf.setVisible(true); // tạo cửa sổ
		jf.setLocation(300,300);// gán vị trí hiển thị
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
