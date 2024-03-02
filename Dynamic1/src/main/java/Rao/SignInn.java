package Rao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/SignInn")
public class SignInn extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		
		String un,pwd;
		   
		   un=req.getParameter("username");
		   
		   pwd=req.getParameter("password");
		  
		   String uname="Ramesh";
		   String pswd="admin";
		   
		   PrintWriter out=resp.getWriter();
		   
		   if(un.equals(uname) && pwd.equals(pswd))
		   {
			  out.println("Login Sucess"); 
			  out.println("User Name :"+un); 
			  out.println("Password : "+pwd); 
			   
		   }
		   else
		   {
			   
				  out.println("Login Faild"); 
			   
		   }
		   
		   
		   ServletConfig conf=getServletConfig();
		   String ss=conf.getInitParameter("cname");
		   System.out.println(ss);
		   
		   
		   
		   
	   }

		
		
	}


