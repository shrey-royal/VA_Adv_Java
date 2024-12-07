package basics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HFF1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setAttribute("attr", req.getParameter("field"));
//		req.getRequestDispatcher("hff2").forward(req, res);
		
//		String n = req.getParameter("field");
		res.getWriter().println("<a href='hff2?attr=ABCD'>Go again!</a>");
	}

}

/*
product:
html -> 
id:
name:
price:

servlet1 -> show details in an html form (id readonly others are editable)

-> servlet2 -> final print


*/