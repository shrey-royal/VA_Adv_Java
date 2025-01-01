package com.vc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.bean.FoodItem;
import com.vc.dao.FoodItemDao;

public class UpdateFoodItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		double price = Double.parseDouble(req.getParameter("price"));
		boolean status = req.getParameter("status").equals("1") ? true : false;
		
		FoodItem item = new FoodItem(id, name, description, price, status);
		FoodItemDao foodItemDao = new FoodItemDao();
		
		if (foodItemDao.updateFoodItem(item)) {
			res.sendRedirect(getServletContext().getContextPath() + "/list");
		} else {
			res.sendError(500, "Failed to Update Item");
		}
		
	}

}
