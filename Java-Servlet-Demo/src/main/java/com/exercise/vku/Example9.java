package com.exercise.vku;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Ex9", value = "/Ex9")
public class Example9 extends GenericServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	}

	public void destroy() {
	}

	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
		servletResponse.setContentType("text/html");
		PrintWriter out = servletResponse.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H1>" + "HI I AM WORING" + "</H1>");

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Ex9Pro");
		rd.include(servletRequest, servletResponse);

		out.println("<H1>" + "HI I AM WORING after comming back" + "</H1>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}
}
