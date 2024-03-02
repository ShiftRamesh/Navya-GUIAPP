package TASK_1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class About extends JFrame {
	
	JLabel jl1;
	JTextArea ja;
	
	public About() {
	
	 jl1=new JLabel("About OUR Company");
	 ja=new JTextArea("\"Shift Edutech is a leading software training institute providing Software Training, Project Guidance");
	 		
		
		jl1.setBounds(250,160,160,60);
		ja.setBounds(100,200,700,80);
		
		add(jl1);
		add(ja);		
	 
	}

}
