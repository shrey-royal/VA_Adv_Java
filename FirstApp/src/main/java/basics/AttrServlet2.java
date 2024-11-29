package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttrServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<center><h2>Name: " + req.getAttribute("name") + "</h2>");
		out.println("<h2>Age: " + req.getAttribute("age") + "</h2>");
		out.println("<h2>Gender: " + req.getAttribute("gender") + "</h2>");
		out.println("<h2>Hobby: " + req.getAttribute("hobby") + "</h2></center>");
		
		out.close();
	}

}
