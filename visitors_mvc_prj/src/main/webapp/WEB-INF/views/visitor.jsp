<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록 입니다.</h1>
	<form action="" method="post">
		<input type="hidden" name="nickname" value="${nickname }"> 
		<textarea rows="10" cols="40" name="content"></textarea>
		<input type="submit" value="등록">
	</form>
</body>
</html>