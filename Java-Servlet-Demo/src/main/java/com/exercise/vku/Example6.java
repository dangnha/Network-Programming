package com.exercise.vku;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "Ex6", value = "/Ex6")  // Specify the URL mapping for this servlet

public class Example6 extends GenericServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
       
		out.println("req.getServerName( ): " + req.getServerName());
        out.println("req.getServerPort( ): " + req.getServerPort());
        out.println("getServletContext( ).getServerInfo( ): " + getServletContext().getServerInfo());
        out.println("getServerInfo( ) name: " + getServerInfoName(getServletContext().getServerInfo()));
        out.println("getServerInfo( ) version: " + getServerInfoVersion(getServletContext().getServerInfo()));
        out.println("getServletContext( ).getAttribute(\"attribute\"): " + getServletContext().getAttribute("attribute"));
        
    }

    private String getServerInfoName(String serverInfo) {
        int s = serverInfo.indexOf('/');
        if (s == -1) 
            return serverInfo;  // Fixed the method call
        else
            return serverInfo.substring(0, s);
    }

    private String getServerInfoVersion(String serverInfo) {
        int s = serverInfo.indexOf('/');
        if (s == -1)
            return null;
        else
            return serverInfo.substring(s + 1);
    }
}
