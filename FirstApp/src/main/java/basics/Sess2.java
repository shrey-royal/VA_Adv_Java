package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess2")
public class Sess2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter o = res.getWriter();
		
		HttpSession s = req.getSession(false);
		String n = (String) s.getAttribute("naam");
		o.println("Hello, " + n + "<br>");
		o.println(s.getId() + "<br>");
		o.println(s.getCreationTime() + "<br>");
		o.println(s.getServletContext().getInitParameter("username") + "<br>");
		o.close();
	}

}
