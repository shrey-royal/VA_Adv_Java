package one;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Bean bean = new Dao().getImgById(Integer.parseInt(req.getParameter("id")));
		if(bean != null) {
			byte[] blobData = bean.getData();
			if(blobData != null) {
				res.setContentType("image/*");
				res.setContentLength(blobData.length);
				
				try {
					OutputStream out = res.getOutputStream();
					out.write(blobData);
					out.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				res.sendError(HttpServletResponse.SC_NOT_FOUND, "No image available.");
			}
		} else {
			res.sendError(HttpServletResponse.SC_NOT_FOUND, "No bean available.");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
