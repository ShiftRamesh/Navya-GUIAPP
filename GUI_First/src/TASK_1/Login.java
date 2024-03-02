package TASK_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
	String un,pwd,fun,fpwd;
	JLabel jl,jl1,jl2;
	JButton jb;
	JTextField jf;
	JPasswordField jp;
	JFrame j=new JFrame();
public Login()
{
	jl=new JLabel("Login Page");
	jl1=new JLabel("User Name");
	jl2=new JLabel("Password");

	jf=new JTextField();
	jp=new JPasswordField();
	jb=new JButton("Login");
	setLayout(null);
	
	jl.setBounds(350,80,160,50);
	jl1.setBounds(300,150,100,30);
	jl2.setBounds(300,200,100,30);
	
	jf.setBounds(400,150,200,30);
	jp.setBounds(400,200,200,30);
	
	jb.setBounds(350,300,80,30);

	
	add(jl);
	add(jl1);
	add(jl2);
	add(jf);
	add(jp);
	add(jb);
	jb.addActionListener(this);

}


public void actionPerformed(ActionEvent ae) {
	
	if(ae.getSource().equals(jb))
	{
		try 
		{
			un=jf.getText();
			pwd=jp.getText();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			System.out.println(con);
			
			PreparedStatement pst=con.prepareStatement("select * from rform where name=?");
			
			pst.setString(1,un);
			
		   ResultSet rs=pst.executeQuery();
		   
		   while(rs.next())
		   {
			   fun=rs.getString(1); //User Name
			   fpwd=rs.getString(4); //Lang
		   }	
		   
		  
		   if(un.equals(fun) && pwd.equals(fpwd))
		   {
			   
			   System.out.println("LOGIN SUCESS");
			   JOptionPane.showMessageDialog(j,"Login Sucess");
				
		   }
		   else
		   {
			   System.out.println("LOGIN FAILED");
			   JOptionPane.showMessageDialog(j,"Login Failed");
		   }
		   
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}	
}
}
