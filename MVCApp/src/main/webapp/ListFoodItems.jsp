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
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
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
            max-width: 1200px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #3f51b5;
            color: white;
            font-size: 1.2rem;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #f5f5f5;
        }

        .mdl-button {
            margin: 0;
        }

        h2 {
            font-size: 2.5rem;
            text-align: center;
        }
        
        img {
        	max-width: 100px;
        	height: auto;
        	border-radius: 5px;
        }
        
        @media screen and (max-width: 768px) {
            table {
                font-size: 18px; /* Adjust font size for smaller screens */
            }
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="logo">MySite</div>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="<%= application.getContextPath() + "/list" %>">ListAllFoodItems</a></li>
            <li><a href="userLogout.jsp">Logout</a></li>
        </ul>
    </nav>

    <!-- List Container -->
    <div class="list-container mdl-shadow--2dp">
        <h2 class="mdl-typography--headline">Menu Items</h2>
        <%
            ArrayList<FoodItem> items = (ArrayList<FoodItem>) request.getAttribute("items");
        %>
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
            <thead>
                <tr>
                    <th class="mdl-data-table__cell--non-numeric">Id</th>
                    <th class="mdl-data-table__cell--non-numeric">Image</th>
                    <th class="mdl-data-table__cell--non-numeric">Name</th>
                    <th class="mdl-data-table__cell--non-numeric">Description</th>
                    <th class="mdl-data-table__cell--non-numeric">Price</th>
                    <th class="mdl-data-table__cell--non-numeric">Availability</th>
                    <th class="mdl-data-table__cell--non-numeric">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td class="mdl-data-table__cell--non-numeric">${item.id}</td>
                        <td class="mdl-data-table__cell--non-numeric"><img src="${item.image_url}" alt="${item.name}"></td>
                        <td class="mdl-data-table__cell--non-numeric">${item.name}</td>
                        <td class="mdl-data-table__cell--non-numeric">${item.description}</td>
                        <td class="mdl-data-table__cell--non-numeric">₹${item.price}</td>
                        <td class="mdl-data-table__cell--non-numeric">${item.status ? "Available" : "Unavailable" }</td>
                        <td class="mdl-data-table__cell--non-numeric">
                            <a class="mdl-button mdl-js-button mdl-button--primary" href="edit?id=${item.id}">Edit</a>
                            <a class="mdl-button mdl-js-button mdl-button--accent" href="delete?id=${item.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
