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
		out.println("Name: " + ck[0].getName() + "<br>Value: " + ck[0].getValue());
		ck[0].setMaxAge(10);	//Delete your cookie
		out.println("Age: " + ck[0].getMaxAge());
	}

}
