package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		Cookie[] ck = req.getCookies();
		out.println("<table border='1'><thead><tr><th>Name</th><th>Value</th><tr></thead><tbody>");
		for (int i = 0; i < ck.length; i++) {
			out.println("<tr><td> " + ck[i].getName() + " </td><td> " + ck[i].getValue() + " </td>");
		}
		out.println("</tbody></table>");
	}

}
