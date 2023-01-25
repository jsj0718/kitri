<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
%>
	<fieldset>
		<legend>로그인</legend>
		<form action="session.jsp" method="POST">
			<label>ID : <input type="text" name="id"></label> <br>
			<label>PW : <input type="password" name="pw"></label> <br> 
<%-- 			<span style="color : red;"><%=msg %></span> <br> --%>
			<input type="submit" value="로그인">
		</form>
	</fieldset>
</body>
</html>