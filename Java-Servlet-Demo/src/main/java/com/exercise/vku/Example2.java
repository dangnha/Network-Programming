package com.exercise.vku;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "Ex2", value = "/Ex2")
public class Example2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter( );
        
        String name = req.getParameter("name");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello, " + name + " Welcome to Servlet Programming</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1>Hello, " + name + " Welcome to the World of Servlet</H1>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}

