package basics.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String n = req.getParameter("username");
		String p = req.getParameter("password");
		
		if (p.equals(getServletContext().getInitParameter("password"))) {
			HttpSession s = req.getSession();
			s.setAttribute("n", n);
			res.sendRedirect("http://localhost:9090/FirstApp/sessprofile");
		} else {
			out.println("<h2 style='color: orangered; margin-right: 30px;'>Sorry, username or password error!</h2>");
			req.getRequestDispatcher("html/sessLogin.html").include(req, res);
		}
	}

}
