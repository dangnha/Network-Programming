package com.exercise.vku;
import java.sql.*;


public class Example10 {
	String ename[] = { "Sameer", "Kuber" };

	public String[] showNames() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:cds");
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			ResultSet rset = st.executeQuery("select custname from customer");
		} catch (Exception e) {
			System.out.println(e);
		}
		return ename;
	}
}
