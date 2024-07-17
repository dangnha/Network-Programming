package com.exercise.vku;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Ex5", value = "/Ex5")
public class Example5 extends GenericServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter( );

        out.println("The Integer parameters are:");
        Enumeration enm = getInitParameterNames();
        while(enm.hasMoreElements( ))
        {
            String name = (String) enm.nextElement( );
            out.println(name + ":" + getInitParameter(name));
        }
    }	
}

