package com.vc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.vc.bean.FoodItem;
import com.vc.dao.FoodItemDao;
import com.vc.util.ImageService;

@MultipartConfig
public class UpdateFoodItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		double price = Double.parseDouble(req.getParameter("price"));
		boolean status = req.getParameter("status").equals("1");
		
		Part imagePart = req.getPart("image");
		String imageUrl = null;
		ImageService imageService = new ImageService();
		
		if (imagePart != null && imagePart.getSize() > 0) {
			imageUrl = imageService.uploadImage(imagePart.getInputStream());
		}
		
		FoodItem item = new FoodItem(id, name, description, price, status, imageUrl);
		FoodItemDao foodItemDao = new FoodItemDao();
		
		if (foodItemDao.updateFoodItem(item)) {
			res.sendRedirect(getServletContext().getContextPath() + "/list");
		} else {
			res.sendError(500, "Failed to Update Item");
		}
		
	}

}
