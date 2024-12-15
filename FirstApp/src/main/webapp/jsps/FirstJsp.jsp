<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page 1</title>
</head>
<body>
	<h1>Welcome to my First JSP page</h1>
	<div>
		<h3>1. Scriptlet Tag</h3>
		<p style="background-color: #ff2d9d; width: fit-content; color: white;"><% out.println(Calendar.getInstance().getTime()); %></p>
		
		<p>
			<%
				for(int i=1; i<=10; i++) {
					out.println("5 * " + i + " = " + 5*i + "<br>");
				}
			%>
		</p>
		
		<h3>2. Expression Tag</h3>
		<p style="background-color: coral; width: fit-content; color: white;"><%= Calendar.getInstance().getTime() %></p>
		<p> <%= 5*20 %> </p>
		
		<h3>3. Declaration Tag</h3>
		<p style="background-color: #ff2d9d; width: fit-content; color: white;"><%! int i = 0; %></p>
		<p>
			<%
				for(i=1; i<=10; i++) {
					out.println("14 * " + i + " = " + 14*i + "<br>");
				}
			%>
		</p>
	</div>
</body>
</html>