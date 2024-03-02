package SessionTechniques;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cookieexp")
public class Cookieexp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  PrintWriter out = resp.getWriter();  
          
		    String un=req.getParameter("name");  
		    String em=req.getParameter("email");  
		 
		    
		    out.print("Welcome To"+un +"  "+em);  
		  
		Cookie ck=new Cookie("uname",un);
		resp.addCookie(ck);
		
		Cookie ck2=new Cookie("email",em);
		resp.addCookie(ck2);
		
		 out.print("<form action='Cookieexp2' method='post'>");  
		 out.print("<input type='text' name='unam'>");  
		 out.print("<input type='submit' value='next'>");  
		    out.print("</form>");  
		          
		   
		
	}

}
