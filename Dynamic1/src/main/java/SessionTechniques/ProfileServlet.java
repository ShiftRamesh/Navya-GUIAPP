package SessionTechniques;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);
        HttpSession session=request.getSession(false);  
        
        if(session!=null)
        {  
        String name=(String)session.getAttribute("name");  
        String email=(String)session.getAttribute("email");  
        out.println("Hey "+name);
        out.println("How are You");
        
        out.println("Mail ID :, "+email);
        
        out.println(session.getCreationTime());
        out.println(session.getLastAccessedTime());
        out.println(session.getId());
        }
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        
	}

	

	}
}
