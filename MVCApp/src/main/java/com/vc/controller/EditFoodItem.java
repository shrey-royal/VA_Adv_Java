package com.vc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.bean.FoodItem;
import com.vc.dao.FoodItemDao;

public class EditFoodItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		FoodItem foodItem = new FoodItemDao().getFoodItemById(id);
		req.setAttribute("item", foodItem);
		
		req.getRequestDispatcher("edit_item.jsp").forward(req, res);
	}
}
