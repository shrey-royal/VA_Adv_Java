package com.vc.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.bean.UserBean;
import com.vc.dao.UserDao;

public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		String role = req.getParameter("role");
		
		boolean isAuthenticated = new UserDao().authUser(new UserBean(uname, pass, role));
		
		if(isAuthenticated) {
			res.sendRedirect(getServletContext().getContextPath() + "/user/list");
		} else {
			res.sendError(401, "Username or Password Error!");
		}
	}

}
