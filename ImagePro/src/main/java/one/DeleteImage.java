package one;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (new Dao().deleteImgById(Integer.parseInt(req.getParameter("id"))))
			req.getRequestDispatcher("/list").forward(req, res);
		else
			res.sendError(500, "Your computer has virus!");
	}

}
