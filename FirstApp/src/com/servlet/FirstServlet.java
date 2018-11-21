package com.servlet;
import java.io.*;
import javax.servlet.*;
public class FirstServlet extends GenericServlet {
 public void init()throws ServletException
 {}
 public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 pw.println("welcome servlet program....");
	 
 }
 public void destroy()
 {}
}
