<%@page import="com.vc.bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Summary</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ccc;
        }
        th {
            background-color: #3f51b5;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f5f5f5;
        }
        h2 {
            text-align: center;
        }
        .total {
            font-size: 22px;
            font-weight: bold;
            text-align: right;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>Order Summary</h2>
    <%
        List<OrderBean> selectedItems = (List<OrderBean>) session.getAttribute("selectedItems");
        Double totalPrice = (Double) session.getAttribute("totalPrice");
    %>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${selectedItems}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.quantity}</td>
                    <td>₹${item.price}</td>
                    <td>₹${item.totalItemPrice}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="total">
        Total Price: ₹<%= totalPrice %>
    </div>
</body>
</html>
