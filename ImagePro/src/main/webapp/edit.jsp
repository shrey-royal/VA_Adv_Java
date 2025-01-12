<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>
<body>
	<img alt="Image" src="image?id=${param.id}">
	<form action="update" enctype="multipart/form-data" method="post">
		<input type="hidden" name="id" value="${param.id}">
		Upload Image: <input type="file" name="image" accept="image/*">
		<br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>