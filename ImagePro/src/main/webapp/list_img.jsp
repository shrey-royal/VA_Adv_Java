<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Images</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Image</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="img" items="${imgs}">
				<tr>
					<td>${img.id}</td>
					<td>${img.name}</td>
					<td>
						<img src="image?id=${img.id}" alt="Image" style="width: 100px; height: auto;" />
					</td>
					<td><a href="edit.jsp?id=${img.id}">Edit</a> | <a href="delete?id=${img.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>