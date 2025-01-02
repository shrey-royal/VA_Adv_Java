package com.vc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.dao.FoodItemDao;

public class DeleteFoodItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		FoodItemDao foodItemDao = new FoodItemDao();
		
		if (foodItemDao.deleteFoodItemById(id)) {
			res.sendRedirect(getServletContext().getContextPath() + "/list");
		} else {
			res.sendError(500, "Error deleting FoodItem!");
		}
	}

}
