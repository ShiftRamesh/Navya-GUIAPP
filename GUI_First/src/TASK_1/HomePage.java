package TASK_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage extends JFrame implements ActionListener{

	ImageIcon ii;
	JLabel jli,jl1;
	
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	
	public HomePage() {
		ii=new ImageIcon("C:\\Users\\RAMA CHANDRA RAO\\eclipse-workspace\\Navya\\GUI_First\\bgm.jpg");
		jli=new JLabel(ii);
		jl1=new JLabel("Welcome To Shift-EduTech");
		jb1=new JButton("About");
		jb2=new JButton("Reg");
		jb3=new JButton("Login");
		jb4=new JButton("Contact");
		jb5=new JButton("Blog");
		jb6=new JButton("Fetch");
		jb7=new JButton("FetchData");
		setLayout(null);
		
		jli.setBounds(0,0,800,600);
		jl1.setBounds(330,50,160,30);
		jb1.setBounds(350,150,100,30);
		jb2.setBounds(350,200,100,30);
		jb3.setBounds(350,250,100,30);
		jb4.setBounds(350,300,100,30);
		jb5.setBounds(350,350,100,30);
		jb6.setBounds(350,400,100,30);
		jb7.setBounds(350,450,100,30);
		add(jl1);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);
		add(jb5);
		add(jb6);
		add(jb7);
		
		add(jli);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);
	}


	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource().equals(jb1))
		{
			About a=new About();
			a.setTitle("Shift.EduTech-Registration Page");
			a.setSize(800,600);
			a.setVisible(true);
		
			a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(ae.getSource().equals(jb2))
		{
			Reg hp=new Reg();
			hp.setTitle("Shift.EduTech-Registration Page");
			hp.setSize(800,600);
			hp.setVisible(true);
			hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(ae.getSource().equals(jb3))
		{
			Login l=new Login();
			l.setTitle("Shift.EduTech-Login Page");
			l.setSize(800,600);
			l.setVisible(true);
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		if(ae.getSource().equals(jb4))
		{
			
		}
		if(ae.getSource().equals(jb5))
		{
			
		}
		if(ae.getSource().equals(jb6))
		{
			Fetch_img l=new Fetch_img();
			l.setTitle("Shift.EduTech-Fetch Image Page");
			l.setSize(800,600);
			l.setVisible(true);
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
		if(ae.getSource().equals(jb7))
		{
			Fecth_Table l=new Fecth_Table();
			l.setTitle("Shift.EduTech-Fetch DATA");
			l.setSize(800,600);
			l.setVisible(true);
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
	}
	
}
