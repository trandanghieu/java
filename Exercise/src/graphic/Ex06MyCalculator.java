package graphic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Ex06MyCalculator extends JFrame {
	public Ex06MyCalculator() {
		this.setTitle("Calculator");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JTextField txtflield = new JTextField();

		JPanel panneltop = new JPanel();

		panneltop.setLayout(new BorderLayout());
		panneltop.add(txtflield, BorderLayout.CENTER);
		

		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");
		JButton btn0 = new JButton("0");

		JButton btnadd = new JButton("+");
		JButton btnsub = new JButton("-");
		JButton btnmul = new JButton("*");
		JButton btndiv = new JButton("/");
		JButton btnsame = new JButton("=");
		
		JPanel panneldown = new JPanel();
		panneldown.setLayout(new GridLayout(5, 3));

		

		FlowLayout flowlayout = new FlowLayout();
		this.setLayout(flowlayout);

		panneldown.add(btn1);
		panneldown.add(btn2);
		panneldown.add(btn3);
		panneldown.add(btn4);
		panneldown.add(btn5);
		panneldown.add(btn6);
		panneldown.add(btn7);
		panneldown.add(btn8);
		panneldown.add(btn9);
		panneldown.add(btn0);
		panneldown.add(btnadd);
		panneldown.add(btnsub);
		panneldown.add(btnmul);
		panneldown.add(btndiv);
		panneldown.add(btnsame);
		
		
		this.setLayout(new BorderLayout());
		this.add(panneltop, BorderLayout.NORTH);
		this.add(panneldown, BorderLayout.CENTER);
		

		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Ex06MyCalculator();

	}
}
