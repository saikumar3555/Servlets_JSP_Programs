package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ViewServlet extends GenericServlet{
	public ServletContext context;
	public RegBean rb;
	public void init()throws ServletException
	{
		context=this.getServletContext();
		rb=new RegBean();
		rb=(RegBean)context.getAttribute("beanref");
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("UserName:"+rb.getUname());
		pw.println("<br>Password:"+rb.getPword());
		pw.println("<br>FirstName:"+rb.getFname());
		pw.println("<br>LastName:"+rb.getLname());
		pw.println("<br>Address:"+rb.getAddr());
		pw.println("<br>PhoneNumber:"+rb.getPhno());
		pw.println("<br>Mail Id:"+rb.getMid());
		pw.print("<br>");
		pw.println("<form action='reg' method='post'>");
		pw.println("<input type='submit' value='Register'>");
		pw.println("</form>");
		
	}

}
