package SessionTechniques;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Biodata")
public class Biodata extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("link.html").include(request, response);
		 PrintWriter out=response.getWriter();  
		 HttpSession session=request.getSession(false);  
	        
	        if(session!=null)
	        {  
	        String name=(String)session.getAttribute("name");  
	        String email=(String)session.getAttribute("email");  
	        String psd=(String)session.getAttribute("pwd");  
	       
	        out.print("Hey "+name);
	        out.print(" 'How are You'");
	        
	        out.print(" Mail ID : "+email);
	        
	        out.print(" Your Password Is : "+psd);
	        
	        out.print("Your data is Sequre");
	        }
	        else{  
	            out.print("Please login first");  
	            request.getRequestDispatcher("login.html").include(request, response);  
	        
		}

			
	
	
	}

	

}
