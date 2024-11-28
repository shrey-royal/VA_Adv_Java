package basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		ServletConfig c = getServletConfig();
		Enumeration<String> e = c.getInitParameterNames();
		
		String str = "";
		out.println("<h1 style='align-items: center;'>Config Params:</h1>");
		while(e.hasMoreElements()) {
			str = e.nextElement();
			out.println(str + " : " + c.getInitParameter(str) + "<br><hr>");
		}
		out.println("<br><br>");
		
		ServletContext context = getServletContext();
		Enumeration<String> e1 = context.getInitParameterNames();
		
		out.println("<h1 style='align-items: center;'>Context Params:</h1>");
		while(e1.hasMoreElements()) {
			str = e1.nextElement();
			out.println(str + " : " + context.getInitParameter(str) + "<br><hr>");
		}
		out.close();
	}

}
