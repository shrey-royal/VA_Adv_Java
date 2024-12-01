package basics.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		req.getRequestDispatcher("html/link.html").include(req, res);
		
		Cookie ck = new Cookie("name", "");
		ck.setMaxAge(0);
		res.addCookie(ck);
		
		out.println("You are successfully logged out!");
        out.close();
	}

}
