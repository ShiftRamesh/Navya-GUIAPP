package STP1;

import javax.swing.JFrame;

public class Frame2 extends JFrame {

	public static void main(String[] args) {
	
		Frame1 f=new Frame1();
		f.setTitle("First-STP");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
