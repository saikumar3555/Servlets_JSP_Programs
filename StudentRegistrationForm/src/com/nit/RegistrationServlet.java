package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.StringJoiner;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegistrationServlet extends GenericServlet{

public Connection con;
public void init()throws SecurityException{
	con=DBConnection.getCon();
}
@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	StringJoiner sj1=new StringJoiner(",");
	StringJoiner sj2=new StringJoiner("-");
	StringJoiner sj3=new StringJoiner("-");
	StringJoiner sj4=new StringJoiner("-");
	StringJoiner sj5=new StringJoiner("-");
	StringJoiner sj6=new StringJoiner("/");
	
	
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
	String day=req.getParameter("day");
	sj6.add(day);
	String month=req.getParameter("month");
	sj6.add(month);
	String year=req.getParameter("year");
	sj6.add(year);
	
	String eid=req.getParameter("eid");
	String phno=req.getParameter("phno");
	String gender=req.getParameter("gender");
	String addr=req.getParameter("addr");
	String city=req.getParameter("city");
	String pincode=req.getParameter("pincode");
	String state=req.getParameter("state");
	String country=req.getParameter("country");
	String hob1=req.getParameter("hob1");
	sj1.add(hob1);
	String hob2=req.getParameter("hob2");
	sj1.add(hob2);
	String hob3=req.getParameter("hob3");
	sj1.add(hob3);
	String hob4=req.getParameter("hob4");
	sj1.add(hob4);
	String hob5=req.getParameter("hob5");
	sj1.add(hob5);
	String xboard =req.getParameter("xboard");
	sj2.add(xboard);
	String xpercentage =req.getParameter("xpercentage");
	sj2.add(xpercentage);
	String ypassing =req.getParameter("ypassing");
	sj2.add(ypassing);
	
	String xiiboard =req.getParameter("xiiboard");
	sj3.add(xboard);
	String xiipercentage =req.getParameter("xiipercentage");
	sj3.add(xpercentage);
	String xiiypassing =req.getParameter("xiiypassing");
	sj3.add(ypassing);
	
	String gboard =req.getParameter("gboard");
	sj4.add(gboard);
	String gperc =req.getParameter("gperc");
	sj4.add(gperc);
	String gpass =req.getParameter("gpass");
	sj4.add(gpass);
	
	String mboard =req.getParameter("mboard");
	sj5.add(mboard);
	String mperc =req.getParameter("mperc");
	sj5.add(mperc);
	String mpass =req.getParameter("mpass");
	sj5.add(mpass);
	
	String course=req.getParameter("course");
	try {
		PreparedStatement ps=con.prepareStatement("insert into studentreg13 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, sj6.toString());
		ps.setString(4, eid);
		ps.setString(5, phno);
		ps.setString(6, gender);
		ps.setString(7, addr);
		ps.setString(8, city);
		ps.setString(9, pincode);
		ps.setString(10, state);
		ps.setString(11, country);
		ps.setString(12, sj1.toString());
		ps.setString(13, sj2.toString());
		ps.setString(14, sj3.toString());
		ps.setString(15, sj4.toString());
		ps.setString(16, sj5.toString());
		ps.setString(17, course);
		int k=ps.executeUpdate();
		if(k>=0) {
			pw.println("Registration Successful...");
		}
		
		
	}catch(Exception e) {}
	
	
	
}

}
