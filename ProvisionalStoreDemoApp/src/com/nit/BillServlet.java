/*package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillServlet extends HttpServlet {
	public ArrayList al;
	
	public ServletContext context;
	public float GrandTotalBill;

	public void init() throws ServletException {
		context = this.getServletContext();
		al=new ArrayList();
//	}

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ArrayList al=(ArrayList)context.getAttribute("ref");
		
		if(al.isEmpty()) {
		String pcode=req.getParameter("pcode");
		String pname=req.getParameter("pname");
		
		float pprice=Float.parseFloat(req.getParameter("pprice"));
		int pqty=Integer.parseInt(req.getParameter("pqty"));
		float GrandTotalBill=pprice*pqty;
		  if(GrandTotalBill>=5000) {
			res.sendRedirect("http://localhost:8081/ProvisionalStoreDemo2/dis?pcode="+pcode+"&pname="+pname+"&totBill="+GrandTotalBill);
			
		}else {
			
		
		pw.println("From Bill Servlet...");
		pw.println("<br>Pcode:"+pcode);
		pw.println("<br>Pname:"+pname);
		
		pw.println("<br>TotalBill:"+GrandTotalBill);}}
		else if(!al.isEmpty()) {
			
			
			al.forEach((k)->
			{
				ProductBean pb=(ProductBean)k;
				pw.println("<br>pname "+pb.getPName()+"<br>pcode "+pb.getPCode()+"<br>pprice "+pb.getPPrice()+"<br>pqty "+pb.getPQty()+"<br>totbill "+pb.getEachProductBill());
				GrandTotalBill=GrandTotalBill+pb.getEachProductBill();
				pb.setGrandTotalBill(GrandTotalBill);
				pw.println("Grand Total Bill:"+pb.getEachProductBill());});
				if(GrandTotalBill>=5000) {
					try {
						res.sendRedirect("http://localhost:8081/ProvisionalStoreDemo2/dis?GrandTotalBill"+GrandTotalBill);
		//			} catch (IOException e) {
						// TODO Auto-generated catch block
			//			e.printStackTrace();
		//			}
			//	}
				
	//		}
					
			
	//	}
		
		
		
		
		


//}
*/