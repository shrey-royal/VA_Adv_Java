package basics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if (email.equals("admin@royal.com") && password.equals("admin")) {
			req.getRequestDispatcher("first").forward(req, res);
		} else {
			res.getWriter().println("<h3 style='color: red'>Email and Password Error!</h3>");
			req.getRequestDispatcher("html/requestCollab.html").include(req, res);
		}
	}

}
