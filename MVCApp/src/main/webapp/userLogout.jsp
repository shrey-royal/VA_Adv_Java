<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
	<%
		session = request.getSession(false);
		if (session != null) {	
			session.invalidate();
		}
		
		response.sendRedirect(getServletContext().getContextPath() + "/");
	%>
</body>
</html>