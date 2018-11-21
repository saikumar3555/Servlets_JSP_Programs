package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class SecondServletDemo
 */
@WebServlet("/SecondServletDemo")
public class SecondServletDemo extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		System.out.println("Hello from sercond servlet");
	//	response.getWriter().println("Hello from second Servlet....!!!!");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Hello from second Servlet....!!!!");
		Map map = new HashMap<>();
	}

}
