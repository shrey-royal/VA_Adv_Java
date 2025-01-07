package com.vc.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.bean.UserBean;
import com.vc.dao.UserDao;

public class RegUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		String role = req.getParameter("role");
		
		UserBean bean = new UserBean(uname, pass, role);
		UserDao dao = new UserDao();
		
		if (dao.addUser(bean)) {
//			res.sendRedirect(getServletContext().getContextPath() + "/user/login");
			req.getRequestDispatcher("login").forward(req, res);
		} else {
			res.sendRedirect(getServletContext().getContextPath() + "/createUser.jsp");
		}
	}

}
