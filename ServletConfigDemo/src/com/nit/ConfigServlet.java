package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.ServerCloneException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConfigServlet extends GenericServlet{
	public ServletConfig sconfig;
	public void init() {
		sconfig=this.getServletConfig();
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("name");
		String configvalue=sconfig.getInitParameter("configvalue");
		pw.println("Name:"+name);
		pw.println("<br>configvalue:"+configvalue);
		pw.println("<br>Servlet Name:"+getServletName());
		
	}

}
