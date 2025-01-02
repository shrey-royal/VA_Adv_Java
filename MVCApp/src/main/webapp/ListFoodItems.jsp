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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <style>
        /* Navbar Styles */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: #333;
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
            transition: color 0.3s;
        }

        .navbar ul li a:hover {
            color: #00bcd4;
        }

        /* Page Content Styles */
        .list-container {
            margin: 20px;
            padding: 20px;
            background: #f5f5f5;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        table.dataTable {
            border-collapse: collapse;
            border-spacing: 0;
            width: 100%;
        }

        table.dataTable th, table.dataTable td {
            text-align: left;
            padding: 8px;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="logo">MySite</div>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">ListAllFoodItems</a></li>
            <li><a href="#">Logout</a></li>
        </ul>
    </nav>

    <!-- List Container -->
    <div class="list-container">
        <h2>Menu Items</h2>
        <%
            ArrayList<FoodItem> items = (ArrayList<FoodItem>) request.getAttribute("items");
        %>
        <table id="myTable" class="display row-border" style="width:100%">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Availability</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>₹${item.price}</td>
                        <td>${item.status ? "Available" : "Unavailable" }</td>
                        <td><a href="edit?id=${item.id}">Edit</a> | <a href="delete?id=${item.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script>
        let table = new DataTable('#myTable');
    </script>
</body>
</html>
