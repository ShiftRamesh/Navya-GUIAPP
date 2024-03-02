package TASK_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Reg  extends JFrame implements ActionListener,ItemListener{

	ImageIcon ii;
	JLabel jl1,jl2,jl3,jl4,lg1,lg2,head,jll;
	JTextField jf1,jf2;
	JRadioButton jr1,jr2;
	JButton jb,jbi;
	JComboBox jcbox;
	String gender,lag;
	String[] lang= {"JAVA","PYTHON","GoLang","DotNet","C++"};
	String imgpath;
	JFrame j=new JFrame();
	
	public Reg() 
	{
	ii=new ImageIcon("C:\\Users\\RAMA CHANDRA RAO\\eclipse-workspace\\Navya\\GUI_First\\bgm.jpg");
	jl1=new JLabel(ii);
	
	jl2=new JLabel("Name :");
	jl3=new JLabel("Email :");
	jl4=new JLabel("Gender :");
	lg1=new JLabel("Male");
	lg2=new JLabel("FeMale");
	head=new JLabel("*** REGISTRATION***");
	jll=new JLabel("Languages :");

	jcbox=new JComboBox(lang);
	
	jf1=new JTextField();
	jf2=new JTextField();
	
	jr1=new JRadioButton();
	jr2=new JRadioButton();
	
	jb=new JButton("Sign Up");
	jbi=new JButton("Upload PIC");
	setLayout(null);
	
	jl1.setBounds(0,0,800,600);
	jl2.setBounds(250, 150, 50,30);
	jl3.setBounds(250, 200, 50,30);
	jl4.setBounds(250, 250, 50,30);
	jll.setBounds(250, 300, 150,30);
	lg1.setBounds(420, 250, 50,30);
	lg2.setBounds(480, 250, 50,30);
	head.setBounds(390, 50, 200,10);
	jf1.setBounds(400, 150, 150,30);
	jf2.setBounds(400, 200, 150,30);
	
	jcbox.setBounds(400, 300, 150,30);
	
	
	jr1.setBounds(400, 255, 18,18);
	jr2.setBounds(460, 255, 18,18);
	
	jbi.setBounds(380, 340, 120,35);
	jb.setBounds(380, 400, 100,40);
	
	add(jbi);
	add(jl2);
	add(jl3);
	add(jl4);
	add(jll);
	add(head);
	add(lg1);
	add(lg2);
	add(jr1);
	add(jr2);add(jcbox);
	add(jf1);add(jf2);
	add(jb);
	
	add(jl1);
	
  jb.addActionListener(this);

  jr1.addActionListener(this);

  jr2.addActionListener(this);
  
  jbi.addActionListener(this);
  jcbox.addItemListener(this);
	}

	
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource().equals(jcbox))
		{
			lag=(String)jcbox.getSelectedItem();
			
			
		}		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		
		
		if(ae.getSource().equals(jr1))
		{
		
			jr2.setSelected(false);
			gender="Male";
			
		}
		
		if(ae.getSource().equals(jr2))
		{
		
			jr1.setSelected(false);
			gender="Female";
			
		}
		
		if(ae.getSource().equals(jbi))
		{
			//Ur Task =>Taking Image frim local system
			//Then file keeping into DB.
			
			JFileChooser jf=new JFileChooser(); //taking image from local system.
			jf.showOpenDialog(null);//Open dialogue box with empty selection
			File ff=jf.getSelectedFile(); //From JF selecting File
			imgpath=ff.getAbsolutePath(); //Taking Exatly Path From File.
			JOptionPane.showMessageDialog(j,"Image Uploaded");
			
			
		}
		
		
	
		if(ae.getSource().equals(jb))
		{
		
			try 
			{
				
				String uname=jf1.getText();
				String email=jf2.getText();
				
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				System.out.println(con);
				
				PreparedStatement pst=con.prepareStatement("insert into rform values(?,?,?,?,?)");
				FileInputStream fi=new FileInputStream(imgpath);//Takeing Input stream to read a Image path from imgpath=ff.getAbsolutePath()
				
				
				pst.setString(1, uname);
				pst.setString(2, email);
				pst.setString(3, gender);
				pst.setString(4, lag);
				pst.setBinaryStream(5,fi);
				
				
				int i=pst.executeUpdate();
				System.out.println("Data Stored"+i);
				
				
				JOptionPane.showMessageDialog(j,"SucessFully Data Stored");
				
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		
		
			
		}
		
		
		
	}


	
}
