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
import javax.servlet.http.HttpSession;

import com.vc.bean.OrderBean;

public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        
        int itemSize = Integer.parseInt(req.getParameter("item_size"));
        List<OrderBean> selectedItems = new ArrayList<OrderBean>();
        double totalPrice = 0.0;

        for (int i = 1; i <= itemSize; i++) {
            String qtyParam = "qty_" + i;
            String priceParam = "price_" + i;
            String nameParam = "name_" + i;

            int quantity = Integer.parseInt(req.getParameter(qtyParam));
            if (quantity > 0) {
                double price = Double.parseDouble(req.getParameter(priceParam));
                String name = req.getParameter(nameParam);
                double totalItemPrice = quantity * price;
                
                selectedItems.add(new OrderBean(name, quantity, price, totalItemPrice));
                totalPrice += totalItemPrice;
            }
        }

        session.setAttribute("selectedItems", selectedItems);
        session.setAttribute("totalPrice", totalPrice);

        res.sendRedirect(getServletContext().getContextPath() + "/orderSummary.jsp");
	}

}
