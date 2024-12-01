package basics.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		req.getRequestDispatcher("html/link.html").include(req, res);

		String n = req.getParameter("name");
		String p = req.getParameter("pass");
		
		if (p.equals("admin")) {
			out.println("You are successfully logged in!");
			out.println("<br> Welcome, " + n);
			
			Cookie ck = new Cookie("name", n);
			res.addCookie(ck);
		} else {
			out.println("<p style='color: red;'>Sorry, username or password error!</p>");
			req.getRequestDispatcher("html/login.html").include(req, res);
		}
		out.close();
	}

}
