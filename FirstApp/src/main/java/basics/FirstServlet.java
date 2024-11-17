package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
//		out.println("<h1>Hello, World!</h1>");
		out.println("<h1>Hello, " + req.getParameter("name") + "!</h1>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
