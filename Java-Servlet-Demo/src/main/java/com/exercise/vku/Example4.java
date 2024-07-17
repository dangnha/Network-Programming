package com.exercise.vku;
//program that displays the count how many times servlet has been accessed

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "Ex4", value = "/Ex4")
public class Example4 extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	int ct = 0;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter( );
		ct++;
		out.println("This servlet has been accessed " + ct + " times");
	}
}
