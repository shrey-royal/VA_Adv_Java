package one;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/update")
@MultipartConfig
public class UpdateImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Part imgPart = req.getPart("image");
		if (imgPart != null && imgPart.getSize() > 0) {
			String imgName = imgPart.getSubmittedFileName();
			InputStream is = imgPart.getInputStream();
			byte[] imgData = IOUtils.toByteArray(is);
			int id = Integer.parseInt(req.getParameter("id"));
			
			
			if (new Dao().updateImg(new Bean(id, imgName, imgData)))
				req.getRequestDispatcher("/list").forward(req, res);
			else
				res.sendError(500, "Your computer has virus!");
		}
	}

}
