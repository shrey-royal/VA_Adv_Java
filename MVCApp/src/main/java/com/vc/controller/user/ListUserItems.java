package com.vc.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vc.dao.FoodItemDao;

public class ListUserItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			String username = (String) session.getAttribute("username");
			if(username == null || username == "") {
				session.setAttribute("unameError", "Please Login First!");
				res.sendRedirect(getServletContext().getContextPath() + "/userLogin.jsp");	
			} else {
				session.setAttribute("items", new FoodItemDao().getAllFoodItem());
				res.sendRedirect(getServletContext().getContextPath() + "/user_list_items.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
