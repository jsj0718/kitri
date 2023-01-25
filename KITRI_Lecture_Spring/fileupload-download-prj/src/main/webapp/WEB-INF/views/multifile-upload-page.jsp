<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>다중 파일업로드 page</h1>
	<form action="multifileupload" method="post" enctype="multipart/form-data">
		<input type="text" name="name"> <br>
		<input type="file" name="uploadfile" multiple="multiple"> <br>
		<input type="submit" value="업로드"> <br>
	</form>
</body>
</html>