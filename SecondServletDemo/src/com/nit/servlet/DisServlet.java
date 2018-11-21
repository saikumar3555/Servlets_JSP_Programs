package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String desg = req.getParameter("desg");

		pw.println("--------EMP details----------");
		pw.print("<br>Employee Id:" + id);
		pw.println("<br>Employee Name:" + name);
		pw.println("<br>Employee Desg:" + desg);

	}

}
