package com.exercise.vku;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "Ex1", value = "/Ex1")
public class Example1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter( );
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Welcome to Servlet Programming</TITLE></HEAD>");
		out.println("<BODY><p>Hello World</p></BODY>");
		out.println("</HTML>");
	}
}
