package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditBookServlet extends HttpServlet {
	public Connection con;
	public void init() throws ServletException {
		con = DBConnection.getCon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String bcode=req.getParameter("bcode");
		String bname=req.getParameter("bname");
		String bauthor=req.getParameter("bauthor");
		float bprice=Float.parseFloat(req.getParameter("bprice"));
		int bqty=Integer.parseInt(req.getParameter("bqty"));
		
		try {
			PreparedStatement ps1=con.prepareStatement("update book13 set bname=? where bcode=?");
			ps1.setString(1, bname);
			ps1.setString(2, bcode);
			int k1=ps1.executeUpdate();
			
			PreparedStatement ps2=con.prepareStatement("update book13 set bauthor=? where bcode=?");
			ps2.setString(1, bauthor);
			ps2.setString(2, bcode);
			int k2=ps2.executeUpdate();
			

			PreparedStatement ps3=con.prepareStatement("update book13 set bprice=? where bcode=?");
			ps3.setFloat(1, bprice);
			ps3.setString(2, bcode);
			int k3=ps3.executeUpdate();
			
			PreparedStatement ps4=con.prepareStatement("update book13 set bprice=? where bcode=?");
			ps4.setInt(1,bqty);
			ps4.setString(2, bcode);
			int k4=ps3.executeUpdate();
			
			if(k4>0) {
				pw.println("Book Details Edited Succesfully");
				RequestDispatcher rd=req.getRequestDispatcher("AdminHomepage.html");
				rd.include(req, res);
			}
			else {
				pw.println("The Book code is not available...");
				RequestDispatcher rd=req.getRequestDispatcher("EditBook.html");
				rd.include(req, res);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
