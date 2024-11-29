package basics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttrServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	req.setAttribute("name", "Vishva");
    	req.setAttribute("age", "21");
    	req.setAttribute("gender", "female");
    	req.setAttribute("hobby", "travelling");
    	
    	
    	req.getRequestDispatcher("attr2").forward(req, res);
    }

}
