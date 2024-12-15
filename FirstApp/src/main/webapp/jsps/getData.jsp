<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Get Data</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #121212; /* Dark background */
            color: #fff; /* White text */
            font-family: Arial, sans-serif;
        }

        table {
            border-collapse: collapse;
            margin: 0 auto;
            width: 50%;
            max-width: 400px;
            border: 1px solid #fff; /* White border */
        }

        td {
            border: 1px solid #fff; /* White border */
            padding: 20px;
            text-align: center;
            font-size: 16px;
        }

        /* Optional: Add hover effect */
        td:hover {
            background-color: #1e1e1e; /* Slightly lighter shade */
            color: #00ffcc; /* Accent color */
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>Name</td>
            <td><%= request.getParameter("name") %></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><%= request.getParameter("pass") %></td>
        </tr>
    </table>
</body>
</html>
