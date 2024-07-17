package com.exercise.vku;


//program that prints the extra path information it receives and resulting transaction to a real path

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Ex7", value = "/Ex7/*")
public class Example7 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter( );
		
		if(req.getPathInfo( ) != null)
		{
			out.println("The file is: " + req.getPathInfo( ));
			out.println("Is stored in " + req.getPathTranslated( ));
			
		}
	}
}
