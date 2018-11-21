package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AccountServlet extends GenericServlet {
	public String uname;
	public Connection con;
	public ServletContext context;
	public LoginBean lb;

	public void init() throws ServletException {
		con = DBConnection.getCon();
		context = this.getServletContext();
		lb=new LoginBean();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		//uname = (String) context.getAttribute("uname");
		lb=(LoginBean)context.getAttribute("beanref");
		 uname=lb.getUname();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from bookreg13 where uname=?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// RequestDispatcher rd=req.getRequestDispatcher("AccountInfo");
				// rd.forward(req,res);
				
				pw.println("<html><head>");
				
				pw.println("<style>");
				pw.println("table,td{");
				pw.println("");	pw.println("border:2px solid black;");	
				pw.println("border-collapse:collapse;");	
				pw.println("padding:10px;");
                pw.println("text-align:center;");
					pw.println("}");
					//pw.print("#tid tbody{background-color:lightgreen; color:white}");
				pw.println("</style>");
				pw.println("</head><body>");
				pw.println("<table align='center' id='tid'><tbody>");
				pw.println("<h3 align='center'>User Details<h3>");
				pw.println("<hr>");
				
				pw.println("<tr><td>UserName:</td>"+"<td>"+rs.getString(1)+"</td>");
				pw.println("</tr>");
				
				pw.println("<tr><td>Password:</td>"+"<td>"+rs.getString(2)+"</td>");
				pw.println("</tr>");
				pw.println("<tr><td>Firstname:</td>"+"<td>"+rs.getString(3)+"</td>");
				pw.println("</tr>");
				pw.println("<tr><td>LastName:</td>"+"<td>"+rs.getString(4)+"</td>");
				pw.println("</tr>");
				pw.println("<tr><td>Address:</td>"+"<td>"+rs.getString(5)+"</td>");
				pw.println("</tr>");
				pw.println("<tr><td>Mobile Number:</td>"+"<td>"+rs.getLong(6)+"</td>");
				pw.println("</tr>");
				pw.println("<tr><td>Mail Id:</td>"+"<td>"+rs.getString(7)+"</td>");
				pw.println("</tr>");
				
				pw.println("<ul>");
				pw.println("<li align='left'><a href='UpdateAccount.html'>UpdateAccount</a></li>");
				pw.println("<li align='left'><a href='DeleteAccount'>DeleteAccount</a></li>");
				pw.println("</ul><body></html>");
				
				
				/*pw.println("<br>Password     :"+rs.getString(2));
				pw.println("<br>Firstname    :"+rs.getString(3));
				pw.println("<br>LastName     :"+rs.getString(4));
				pw.println("<br>Address      :"+rs.getString(5));
				pw.println("<br>Mobile Number:"+rs.getLong(6));
				pw.println("<br>Mail Id      :"+rs.getString(7));
				pw.println("</tr>");*/
			}

		} catch (Exception e) {
		}
	}

}
