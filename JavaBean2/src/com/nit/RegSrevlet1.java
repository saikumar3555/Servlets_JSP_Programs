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

public class RegSrevlet1  extends GenericServlet {
	public ServletContext context;
	public RegBean rb;
	public void init()throws ServletException
	{
		context=this.getServletContext();
		rb=new RegBean();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		String repword=req.getParameter("repword");
		rb.SetUname(uname);
		rb.SetPword(pword);
		context.setAttribute("beanref",rb);
		RequestDispatcher rd=req.getRequestDispatcher("input2.html");
		rd.forward(req, res);
		
	}

}
