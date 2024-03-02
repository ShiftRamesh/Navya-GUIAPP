package SessionTechniques;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    

	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter(); 
		  req.getRequestDispatcher("link.html").include(req, resp);  
	    
		  String nm=req.getParameter("name");  
		  String em=req.getParameter("email");  
          String pas=req.getParameter("pwd");  
		
		String n="Ramesh";
		String p="12345";
          
          if(nm.equals(n) && pas.equals(p))
          {  
        	  out.print("Login Sucess");  
              out.print("Welcome, "+nm);
              
              HttpSession hs=req.getSession();
              
              hs.setAttribute("name",nm);  
              hs.setAttribute("email",em); 
              hs.setAttribute("pwd",pas); 
              
             
          }  
              else{  
                  out.print("Sorry, username or password error!");  
                  req.getRequestDispatcher("login.html").include(req, resp);  
              }  
          
	}

}
