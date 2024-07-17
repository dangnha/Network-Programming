package com.exercise.vku;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shopping")
public class Example8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Example8() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);

		HttpSession session = req.getSession(true);
		Integer icount = (Integer) session.getValue("icount");
		if (icount == null) {
			icount = new Integer(0);
		}
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String iselected[];
		String iname;

		String uname = req.getParameter("uname");
		out.println("<h1> Hi," + uname + "</h1>");
		iselected = req.getParameterValues("item");

		if (iselected != null) {
			for (int i = 0; i < iselected.length; i++) {
				iname = iselected[i];
				icount = new Integer(icount.intValue() + 1);
				session.putValue("Item" + icount, iname);
				session.putValue("icount", icount);
			}
		}

		out.println("<html>");
		out.println("<body>");
		out.println("<h2> Items In Your Cart </h2>");
		out.println("<hr>");

		for (int i = 1; i <= icount.intValue(); i++) {
			String item = (String) session.getValue("Item" + i);
			out.println("<ul>");
			out.println("<li>" + item + "</li>");
			out.println("</ul>");
		}

		out.println("<hr>");
		out.println("<a href=#>" + "Back" + "</a>");
		out.close();
	}
}
