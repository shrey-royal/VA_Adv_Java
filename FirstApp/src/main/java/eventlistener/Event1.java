package eventlistener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Event1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String n = req.getParameter("uname");
		out.println("Welcome, " + n);
		
		
		HttpSession s = req.getSession();
		s.setAttribute("uname", n);
		
		ServletContext ctx = getServletContext();
		int t = (Integer) ctx.getAttribute("totalusers");
		int c = (Integer) ctx.getAttribute("currentusers");
		
		out.println("<br>total users = " + t);
		out.println("<br>current users = " + c);
		
		out.println("<br><a href='evelislogout'>Logout</a>");
		out.close();
	}

}
