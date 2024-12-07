package basics.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		HttpSession s = req.getSession(false);
		
		if(s != null) {
			s.invalidate();
			res.getWriter().println("<h2 style='color: tomato;'>You are successfully logged out!</h2>");
		} else {
			res.getWriter().println("<h2 style='color: tomato;'>You are logged out!</h2>");
		}
	}
}
