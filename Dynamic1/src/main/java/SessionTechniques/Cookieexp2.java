package SessionTechniques;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookieexp2")
public class Cookieexp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  PrintWriter out = resp.getWriter();  
          try
          {
		  Cookie ck[]=req.getCookies();
		 
		  
		  String nn=ck[0].getValue();
		  String ema=ck[1].getValue();
		 
		  out.print("<Hi...>"+nn);  
		  out.print("<Hi...>"+ema);  
		  
          }
          catch (Exception e) {
			e.printStackTrace();
		}
          }

}
