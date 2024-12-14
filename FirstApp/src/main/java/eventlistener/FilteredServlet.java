package eventlistener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilteredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.getWriter().println("<h1 style='color: tomato;'>Hello from Darjiben</h1>");
		res.getWriter().println("<h2 style='color: coral;'>Darjiben is filtered now!</h2>");
	}

}
