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
</head>
<body>
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
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>
                    	<td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>₹${item.price}</td>
                        <td>${item.status}</td>
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
