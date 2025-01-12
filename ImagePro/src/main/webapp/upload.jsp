<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>
<body>
	<form action="up" enctype="multipart/form-data" method="post">
		Upload Image: <input type="file" name="image" accept="image/*">
		<br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>