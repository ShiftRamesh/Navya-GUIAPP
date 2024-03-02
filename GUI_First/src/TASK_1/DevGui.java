package TASK_1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DevGui extends JFrame {

	public static void main(String[] args) {

		HomePage hp = new HomePage();

		hp.setTitle("Shift.EduTech-HomePage");

		hp.setSize(800, 600);
		hp.setVisible(true);

		hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

}
