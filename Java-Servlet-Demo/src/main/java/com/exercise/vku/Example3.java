package com.exercise.vku;

//program that displays the current time
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "Ex3", value = "/Ex3")
public class Example3 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter( );
        Date date = new Date( );
        DateFormat dtft = DateFormat.getInstance( );

        String s = request.getParameter("s");
        if(s != null)
        {
            TimeZone tzne = TimeZone.getTimeZone(s);
            dtft.setTimeZone(tzne);
            out.println(dtft.format(date));
        }
    }

    public void destroy() {
    }
}
