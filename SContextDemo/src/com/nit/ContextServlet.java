package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ContextServlet extends GenericServlet{
    public ServletContext scontext;
	   public void init()throws ServletException{
		   scontext=this.getServletContext();
	   }
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("name");
		String cname=scontext.getInitParameter("cname");
		pw.println("Welcome :"+name);
		pw.println("<br>ContextValue :"+cname);
		String server=scontext.getServerInfo();
		pw.println("<br>server Info :"+server);
	}

}
