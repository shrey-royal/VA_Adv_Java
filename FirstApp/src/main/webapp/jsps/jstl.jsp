<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<c:set var="i" value="6"/>
	<h2>i = ${ i+40 }</h2>
	
	<c:set var="userName" value="user"/>
	<h2>Hello, <c:out value="${userName}"/>!</h2>
	
	<c:if test="${ i > 90 }">
		<c:out value="Condition is True"/>
	</c:if>
	<c:if test="${ !(i > 90) }">
		<c:out value="Condition is False"/>
	</c:if>
	<br>
	<a href="<c:url value='/'/>" target="_blank">Click here!</a>
</body>
</html>