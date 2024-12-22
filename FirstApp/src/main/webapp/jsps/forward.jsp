<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp:forward</title>
</head>
<body>
	<!-- With Parameters -->
	<jsp:forward page="getData.jsp">
		<jsp:param name="name" value="Darjiben" />
		<jsp:param name="pass" value="darjipro" />
	</jsp:forward>

	<!-- Without Parameters -->
	<jsp:forward page="getData.jsp"/>
</body>
</html>