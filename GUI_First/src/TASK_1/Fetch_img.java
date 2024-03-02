package TASK_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fetch_img extends JFrame implements ActionListener {
	
	JButton jb;
	JLabel jl;
	Fetch_img()
	{
		
		jb=new JButton("Fetch PIC");
		jl=new JLabel();
		setLayout(null);
		
		jl.setBounds(200, 100,300,350);
		jb.setBounds(380, 340, 120,35);
		
		
		add(jb);
		add(jl);
		jb.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==(jb))
		{
			try {
				
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				System.out.println(con);
				
				PreparedStatement pst=con.prepareStatement("select * from rform where name='Sai Prasad'");
				ResultSet rs=pst.executeQuery();
				
				File fm=new File("rr.jpg");
				FileOutputStream fo=new FileOutputStream(fm);
				
				for(;rs.next();)
				{
					
					
					InputStream ii=rs.getBinaryStream(5);
					System.out.println(ii);
					for(int ir;(ir=ii.read())!=-1;ir++)
					{
						
						fo.write(ir);
					}
					
					ImageIcon iii=new ImageIcon(fm.getAbsolutePath());
					jl.setIcon(iii);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
}
