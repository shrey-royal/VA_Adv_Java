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
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .list-container {
            background: #ffffff;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            width: 100%;
            height: 80vh; /* Define height for scrollable container */
            overflow-y: auto; /* Enable vertical scrolling */
        }
        .list-container h2 {
            margin-bottom: 20px;
            color: #333333;
            text-align: center;
        }
        .menu-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: #f9f9f9;
            border: 1px solid #dddddd;
            border-radius: 5px;
            padding: 15px;
            margin-bottom: 15px;
        }
        .menu-item-details {
            flex: 1;
        }
        .menu-item-details h3 {
            margin: 0;
            font-size: 18px;
            color: #333333;
        }
        .menu-item-details p {
            margin: 5px 0;
            font-size: 14px;
            color: #555555;
        }
        .menu-item-actions {
            display: flex;
            gap: 10px;
        }
        .menu-item-actions button {
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            color: #ffffff;
        }
        .menu-item-actions .edit {
            background-color: #28a745;
        }
        .menu-item-actions .edit:hover {
            background-color: #218838;
        }
        .menu-item-actions .delete {
            background-color: #dc3545;
        }
        .menu-item-actions .delete:hover {
            background-color: #c82333;
        }
        /* Custom scrollbar styling */
        .list-container::-webkit-scrollbar {
            width: 10px;
        }
        .list-container::-webkit-scrollbar-thumb {
            background: #888; /* Color of the scrollbar */
            border-radius: 5px; /* Rounded corners */
        }
        .list-container::-webkit-scrollbar-thumb:hover {
            background: #555; /* Darker shade on hover */
        }
        .list-container::-webkit-scrollbar-track {
            background: #f1f1f1; /* Background track of the scrollbar */
        }
    </style>
</head>
<body>
    <div class="list-container">
        <h2>Menu Items</h2>
        <%
        	ArrayList<FoodItem> items = (ArrayList<FoodItem>) request.getAttribute("items");
        %>
        
        <c:forEach var="item" items="${ items }">
        	<div class="menu-item">
	            <div class="menu-item-details">
	                <h3>${ item.getName() }</h3>
	                <p>Description: ${ item.getDescription() }</p>
	                <p>Price: INR ${ item.getPrice() }</p>
	                <p>Status: ${ item.isStatus() }</p>
	            </div>
	            <div class="menu-item-actions">
	                <button class="edit">Edit</button>
	                <button class="delete">Delete</button>
	            </div>
	        </div>
        </c:forEach>
    </div>
</body>
</html>