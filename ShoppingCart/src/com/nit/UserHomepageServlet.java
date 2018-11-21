package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserHomepageServlet extends HttpServlet  {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	 HttpSession hs=req.getSession();
	 if(hs==null) {
		 RequestDispatcher rd=req.getRequestDispatcher("Login.html");
 		rd.forward(req, res);
 		return;
	 }
	 String uname=(String)hs.getAttribute("username");
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 pw.println("<html><head>");
	 pw.println("<title>My Shopping cart</title>");
	 pw.println("</head><body>");
	 pw.println("<table width='100%' height='90%' border='1'>");
	 pw.println("<tr align='center'>");
	 pw.println("<td height='39' colspan='2'>");
	 pw.println("<strong><font size='5'>My Shopping Cart</font>");
	 
	 pw.println("</strong>");
	 pw.println("</tr>");
	 pw.println("<tr>");
	 pw.println("<td width='18%' height='500' valign='top'>");
	 pw.println("<p>&nbsp</p>");
	 pw.println("<blackquote><p>");
	 pw.println("<a href='"+res.encodeURL("getproducts")+"'>");
	 pw.println("View Products</a></p>");
	 pw.println("<a href='"+res.encodeURL("getcart")+"'>");
	 pw.println("View CartDetails</a></p>");
	 pw.println("<a href='"+res.encodeURL("userlogout")+"'>");
	 pw.println("Logout</a></p>");
	 pw.println("</blockquote></td>");
	 pw.println("<td width='82' align='left' valign='top'>");
	 pw.println("<font size='6'>Welcome,"+uname+"</font></td>");
	 pw.println("</tr>");
	 pw.println("<tr align='center'>");
	 pw.println("<td colspan='2'>");
	 pw.println("<em>&copy;Copyrights 2018</em></td>");
	 pw.println("</tr>");
	 pw.println("</table>");
	 pw.println("</body></html>");
	 pw.flush();
	 pw.close();
	 
	}

}
