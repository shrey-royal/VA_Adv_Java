<%@page import="com.vc.bean.FoodItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Menu Item</title>
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
        
        img {
        	max-width: 100px;
        	height: auto;
        	border-radius: 5px;
        }
        
        .form-container {
            background: #ffffff;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        
        .form-container h2 {
            margin-bottom: 20px;
            color: #333333;
            text-align: center;
        }
        
        .form-group {
            margin-bottom: 15px;
        }
        
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555555;
        }
        
        .form-group input,
        .form-group textarea,
        .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #dddddd;
            border-radius: 5px;
            font-size: 14px;
        }
        
        .form-group textarea {
            resize: vertical;
        }
        
        .form-group input:focus,
        .form-group textarea:focus,
        .form-group select:focus {
            border-color: #007BFF;
            outline: none;
            box-shadow: 0 0 3px rgba(0, 123, 255, 0.5);
        }
        
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            color: #ffffff;
            font-size: 16px;
            cursor: pointer;
        }
        
        .form-group button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
	<% FoodItem item = (FoodItem) request.getAttribute("item"); %>
    <div class="form-container">
        <h2>Add New Menu Item</h2>
        <form action="update" method="POST" enctype="multipart/form-data">
        	<input type="hidden" name="id" value="${item.id}">
            <div class="form-group">
                <label for="name">Item Name</label>
                <input type="text" id="name" name="name" value="${item.name}" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" rows="4">${item.description}</textarea>
            </div>

            <div class="form-group">
                <label for="price">Price (INR)</label>
                <input type="number" id="price" name="price" step="0.01" value="${item.price}" required>
            </div>

            <div class="form-group">
                <label for="status">Availability Status</label>
                <select id="status" name="status">
                    <option value="1" selected>Available</option>
                    <option value="0">Unavailable</option>
                </select>
            </div>
            
            <div class="form-group">
            	<img alt="${item.name}" src="${item.image_url}">
                <label for="image">Upload Image</label>
                <input type="file" id="image" name="image" accept="image/*">
            </div>

            <div class="form-group">
                <button type="submit">Update Item</button>
            </div>
        </form>
    </div>
</body>
</html>
    