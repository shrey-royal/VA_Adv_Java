<%@page import="com.vc.bean.FoodItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Items</title>
    <style>
        /* Navbar Styles */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: #3f51b5;
            color: white;
        }

        .navbar .logo {
            font-size: 20px;
            font-weight: bold;
        }

        .navbar ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
            gap: 15px;
        }

        .navbar ul li {
            display: inline;
        }

        .navbar ul li a {
            text-decoration: none;
            color: white;
            font-weight: 500;
            transition: color 0.3s;
        }

        .navbar ul li a:hover {
            color: #00bcd4;
        }

        /* Page Content Styles */
        .list-container {
            margin: 20px auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            font-size: 20px; /* Increased text size */
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ccc; /* Added border for better visibility */
        }

        th {
            background-color: #3f51b5;
            color: white;
            font-size: 22px;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #f5f5f5;
        }

        h2 {
            font-size: 28px; /* Made the header larger */
            text-align: center;
        }
        
        img {
        	max-width: 100px;
        	height: auto;
        	border-radius: 5px;
        }

        input[type="text"] {
            width: 50px;
            text-align: center;
            font-size: 16px; /* Increased input text size */
        }

        .quantity-controls {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
        }

        .quantity-controls button {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            border: none;
            background-color: #3f51b5;
            color: white;
            font-size: 18px;
            cursor: pointer;
        }

        .quantity-controls button:hover {
            background-color: #303f9f;
        }

        @media screen and (max-width: 768px) {
            table {
                font-size: 18px; /* Adjust font size for smaller screens */
            }
        }
    </style>

    <script>
        function increaseValue(id) {
            const input = document.getElementById(id);
            let currentValue = parseInt(input.value, 10);
            input.value = currentValue + 1;
        }

        function decreaseValue(id) {
            const input = document.getElementById(id);
            let currentValue = parseInt(input.value, 10);
            if (currentValue > 0) {
                input.value = currentValue - 1;
            }
        }
    </script>

</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="logo">Order Food</div>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">ListAllFoodItems</a></li>
            <li><a href="userLogout.jsp">Logout</a></li>
        </ul>
    </nav>

    <!-- List Container -->
    <div class="list-container">
        <h2>Menu Items</h2>
        <%
            ArrayList<FoodItem> items = (ArrayList<FoodItem>) session.getAttribute("items");
        %>
        <form action="user/confirmorder" method="POST">
        <input type="hidden" name="item_size" value="${items.size()}">
	        <table>
	            <thead>
	                <tr>
	                    <th>Id</th>
	                    <th>Image</th>
	                    <th>Name</th>
	                    <th>Description</th>
	                    <th>Price</th>
	                    <th>Availability</th>
	                    <th>Quantity</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="item" items="${items}">
	                    <tr>
	                        <td>${item.id}</td>
	                        <td><img src="${item.image_url}" alt="${item.name}"></td>
	                        <td>${item.name}</td>
	                        <td>${item.description}</td>
	                        <td>₹${item.price}</td>
	                        <td>${item.status ? "Available" : "Unavailable" }</td>
	                        <td>
	                            <div class="quantity-controls">
	                                <button type="button" onclick="decreaseValue('quantity-${item.id}')">-</button>
	                                <input type="text" id="quantity-${item.id}" name="qty_${item.id}" value="0" readonly />
	                                <button type="button" onclick="increaseValue('quantity-${item.id}')">+</button>
	                            </div>
	                            <input type="hidden" name="price_${item.id}" value="${item.price}">
                        		<input type="hidden" name="name_${item.id}" value="${item.name}">
	                        </td>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
	        <button type="submit" style="margin-top: 20px; padding: 10px 20px; background-color: #3f51b5; color: white; font-size: 18px; border: none; border-radius: 5px; cursor: pointer;">
		        Confirm Order
		    </button>
		</form>
    </div>
</body>
</html>
