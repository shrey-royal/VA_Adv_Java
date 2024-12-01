package basics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("fn") + req.getParameter("ln");
		
		Cookie ck1 = new Cookie("name", name);
		
		res.addCookie(ck1);
		
		req.getRequestDispatcher("cookies2").forward(req, res);
	}

}
