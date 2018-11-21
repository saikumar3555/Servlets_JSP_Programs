package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream.Filter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter  implements Filter{
	public Connection con;
	public void init(FilterConfig sc)throws ServletException{
		con=DBConnection.getCon();
	}
 public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws ServletException,IOException{
	 PrintWriter pw=res.getWriter();
	 String uname=req.getParameter("uname");
	 String pword=req.getParameter("pword");
	 try {
		 PreparedStatement ps=con.prepareStatement("select * from userreg13 where uname=? and pword=?");
		 ps.setString(1, uname);
		 ps.setString(2, pword);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()) {
			 chain.doFilter(req, res);
		 }else {
			 pw.println("Inavalid username or password");
			 RequestDispatcher rd=req.getRequestDispatcher("login.html");
			 rd.include(req, res);
		 }
		 }catch (Exception e) {
			// TODO: handle exception
		}
 }
@Override
public boolean accept(Object entry) throws IOException {
	// TODO Auto-generated method stub
	return false;
}
}
