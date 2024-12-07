package basics.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession s = req.getSession(false);
		
		if(s != null) {
			String n = (String) s.getAttribute("n");
			out.println("<h2 style='color: cadetblue;'>Welcome, "+n+"</h2>");
			out.println("<a href='sesslogout'>Logout</a>");
		} else {
			out.println("<h2 style='color: orangered; margin-right: 30px;'>Please login first</h2>");
			req.getRequestDispatcher("html/sessLogin.html").include(req, res);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
