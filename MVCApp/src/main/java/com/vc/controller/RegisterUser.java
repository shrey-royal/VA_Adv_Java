package com.vc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		String role = req.getParameter("role");
		
		String unameError = null, passError = null;
		
		if (uname == null || uname.equals("")) {
			unameError = "Username can't be empty";
			req.setAttribute("unameError", unameError);
		}
		
		if (pass == null || pass.equals("")) {
			passError = "Password can't be empty";
			req.setAttribute("passError", passError);
		}
		
		if (unameError == null || passError == null) {
			//error free (session create)
			res.getWriter().println("No error");
		} else {
			//contains error
			req.getRequestDispatcher("createUser.jsp").forward(req, res);
		}
		
		
	
	}

}
