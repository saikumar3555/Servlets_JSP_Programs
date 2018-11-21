package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminProfileViewServlet extends HttpServlet {
	public String Auname;
	 public String Apword;
	public Connection con;
	public void init() throws ServletException {
		con = DBConnection.getCon();
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie ck[]=req.getCookies();
		
			Auname=ck[0].getValue();
			 Apword=ck[1].getValue();
		
		
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from adminreg23 where uname=? and pword=?");
			ps.setString(1, Auname);
			ps.setString(2, Apword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("---Admin Details----");
				pw.println("<br>UserName:"+rs.getString(1));
				pw.println("<br>PassWord:"+rs.getString(2));
				pw.println("<br>FirstName:"+rs.getString(3));
				pw.println("<br>LastName:"+rs.getString(4));
				pw.println("<br>Address:"+rs.getString(5));
				pw.println("<br>PhoneNumber:"+rs.getString(6));
				pw.println("<br>MailId:"+rs.getString(7));
				
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		//pw.println("check");
		}
}
