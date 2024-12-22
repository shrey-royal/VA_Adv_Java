<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp:include</title>
</head>
<body>
	<jsp:include page="FirstJsp.jsp" />
	
	<jsp:include page="getData.jsp">
		<jsp:param value="darjiben plus" name="name"/>		
	</jsp:include>
</body>
</html>