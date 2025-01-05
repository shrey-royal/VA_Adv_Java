package com.vc.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Map<Integer, Integer> qtys = new HashMap<Integer, Integer>();
		int item_qty;
		int size = Integer.parseInt(req.getParameter("item_size"));
		for (int i = 0; i < size; i++) {
			item_qty = Integer.parseInt(req.getParameter("qty_"+i));
			if(item_qty > 0) {
				qtys.put(i, item_qty);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : qtys.entrySet()) {
			System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
		}
	}

}
