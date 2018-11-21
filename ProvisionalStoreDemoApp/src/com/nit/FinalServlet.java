package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinalServlet extends HttpServlet {

	public ProductBean pb;
	public ArrayList al;
	public float GrandTotal;

	public void init() throws ServletException {
		pb = new ProductBean();
		al = new ArrayList();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String submit = req.getParameter("submit");
		// Bill
		if (submit.equals("Bill")) {
			if (al.isEmpty()) {
				String pcode = req.getParameter("pcode");
				String pname = req.getParameter("pname");

				float pprice = Float.parseFloat(req.getParameter("pprice"));
				int pqty = Integer.parseInt(req.getParameter("pqty"));
				float GrandTotal = pprice * pqty;
				
				if (GrandTotal >= 5000) {
					res.sendRedirect("http://localhost:8081/ProvisionalStoreDemo2/dis?GrandTotal=" + GrandTotal+"&name=sai");
				} else {
					pw.println("<br>Pcode: " + pcode);
					pw.println("<br>Pcode: " + pname);
					pw.println("<br>Pcode: " + pprice);
					pw.println("<br>Pcode: " + pqty);
					pw.println("<br>Total Amount :" + GrandTotal);
				}
			} else {
				al.forEach((k) -> {
					ProductBean pb = (ProductBean) k;
					pw.println("<br>pcode " + pb.getPCode() + "<br>pname " + pb.getPName() + "<br>pprice "
							+ pb.getPPrice() + "<br>pqty " + pb.getPQty() + "<br>TotalAmount " + pb.getTotalAmount());
					GrandTotal = GrandTotal + pb.getTotalAmount();
					pw.println("<br>");
				});
				pw.println("<hr>Grand total Amount" + GrandTotal);
				if (GrandTotal >= 5000) {
					res.sendRedirect("http://localhost:8081/ProvisionalStoreDemo2/dis?GrandTotal=" + GrandTotal);
				}

			}

		} else {// submit=next>>

			String pcode = req.getParameter("pcode");
			String pname = req.getParameter("pname");

			float pprice = Float.parseFloat(req.getParameter("pprice"));
			int pqty = Integer.parseInt(req.getParameter("pqty"));
			float TotalAmount = pprice * pqty;

			pb.setPCode(pcode);
			pb.setPName(pname);
			pb.setPPrice(pprice);
			pb.setPQty(pqty);
			pb.setTotalAmount(TotalAmount);
			al.add(pb);
			RequestDispatcher rd = req.getRequestDispatcher("Product.html");
			rd.forward(req, res);
		}
	}

}
