package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.GenericSignatureFormatError;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegServlet2  extends GenericServlet {
	public ServletContext context;
	public RegBean rb;
	public void init()throws ServletException
	{
		context=this.getServletContext();
		rb=new RegBean();
		rb=(RegBean)context.getAttribute("beanref");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String addr=req.getParameter("addr");
		//String dd=req.getParameter("phno");
		long phno=Long.parseLong(req.getParameter("phno"));
		String mid=req.getParameter("mid");
		rb.SetFname(fname);
		rb.SetLname(lname);
		rb.SetAddr(addr);
		rb.SetPhno(phno);
		rb.SetMid(mid);
		
		
		pw.println("To view Registration Details click");
		pw.println("<a href='view'>View</a>");
		
	}

}
