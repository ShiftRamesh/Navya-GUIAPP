package DataOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String fn;
	String ln;
	String email;
	String gender;
	String city;
	String country;
   
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		
		fn=req.getParameter("fname");
		ln=req.getParameter("lname");
		email=req.getParameter("email");
		gender=req.getParameter("gender");
	 city=req.getParameter("city");
	country=req.getParameter("country");
		
		
		
		
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	
	System.out.println(con);
	
	PreparedStatement pst=con.prepareStatement("insert into webapp1 values(?,?,?,?,?,?)");
	
	pst.setString(1,fn);
	pst.setString(2,ln);
	pst.setString(3,email);
	pst.setString(4,gender);
	pst.setString(5,city);
	pst.setString(6,country);
	
	int ii=pst.executeUpdate();
	
	out.println("<a href='signin.html'>Login</a>");
	
	//RequestDispatcher rd=req.getRequestDispatcher("Home.html");
	//rd.forward(req, resp);
	
	con.close();
}
catch (Exception e) {
	e.printStackTrace();
}
	
		}

}
