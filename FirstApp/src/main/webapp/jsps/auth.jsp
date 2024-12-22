<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auth</title>
</head>
<body>
	<%
		String n = request.getParameter("n");
		String p = request.getParameter("p");
		session = request.getSession();

		if (p.equals(getServletContext().getInitParameter("pass"))) {
			session.setAttribute("n", n);
		} else {
			session.setAttribute("n", "No such user found!");
		}
	%>
	
	<jsp:forward page="home.jsp"/>
</body>
</html>