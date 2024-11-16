package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetRequestData extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String firstName = req.getParameter("fn");
		String lastName = req.getParameter("ln");
		String contact = req.getParameter("contact");
		String gender = req.getParameter("gender");
		
		PrintWriter out = res.getWriter();
		
		out.print("<html lang='en'><head><title>Get Request Data</title></head><body>");
		out.print("<h1>Request Data</h1>");
		out.print("<p><b>First Name:</b>" + firstName + "</p>");
		out.print("<p><b>Last Name:</b>" + lastName + "</p>");
		out.print("<p><b>Contact:</b>" + contact + "</p>");
		out.print("<p><b>Gender:</b>" + gender + "</p>");
		
		out.println("</body></html>");
	}
*/

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String firstName = req.getParameter("fn");
		String lastName = req.getParameter("ln");
		String contact = req.getParameter("contact");
		String gender = req.getParameter("gender");
		
		PrintWriter out = res.getWriter();
		
		out.print("<html lang='en'><head><title>Get Request Data</title></head><body>");
		out.print("<h1>Request Data</h1>");
		out.print("<p><b>First Name:</b>" + firstName + "</p>");
		out.print("<p><b>Last Name:</b>" + lastName + "</p>");
		out.print("<p><b>Contact:</b>" + contact + "</p>");
		out.print("<p><b>Gender:</b>" + gender + "</p>");
		
		out.println("</body></html>");
	}

}
