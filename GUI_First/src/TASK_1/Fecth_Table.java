package TASK_1;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Fecth_Table extends JFrame implements ActionListener 
{

	JButton jb;
	String col [] = {"NAME","EMAIL", "GENDER","LANGUAGE"};
	Fecth_Table()
	{
		
		jb=new JButton("FetchData");
		
		setLayout(null);
		
		
		jb.setBounds(380, 500, 120,35);
		
		
		add(jb);
		
		jb.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==(jb))
		{
			try {
				
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				System.out.println(con);
				
				PreparedStatement pst=con.prepareStatement("select * from rform");
				ResultSet rs=pst.executeQuery();
				
				  JFrame frame1 = new JFrame("Database Search Result");
			        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame1.setLayout(new BorderLayout());
			       
			        DefaultTableModel model = new DefaultTableModel();
			        model.setColumnIdentifiers(col);
			        
			        JTable table = new JTable();
			        table.setModel(model);
			        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			        table.setFillsViewportHeight(true);
			        JScrollPane scroll = new JScrollPane(table);
			        scroll.setHorizontalScrollBarPolicy(
			                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			        scroll.setVerticalScrollBarPolicy(
			                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			        
			       
			        String name = "";
			        String email = "";
			        String gender = "";
			        String language = "";
			        int i = 0;
			        for(;rs.next();) {
		                name = rs.getString("name");
		                email = rs.getString("email");
		                gender = rs.getString("gender");
		                language = rs.getString("lang");
		                model.addRow(new Object[]{name, email, gender, language});
		                i++;
		                
		                frame1.add(scroll);
		                frame1.setVisible(true);
		                frame1.setSize(400, 300);
		            }

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
}
