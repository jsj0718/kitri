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
	request.setCharacterEncoding("UTF-8");	

	String id = "";
	String checked ="";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("idCheck")) {
				id = cookie.getValue();
				checked = "checked";
			}
		}
	}
	
	String msg = request.getParameter("msg");
// 	String msg = (String) request.getAttribute("msg");
	if (msg == null) {
		msg = "";
	}
%>
	<fieldset>
		<legend>로그인</legend>
		<form action="cookie.jsp" method="POST">
			<label>ID : <input type="text" name="id" value=<%=id %>></label> <br>
			<label>PW : <input type="password" name="pw"></label> 
			<span style="color : red;"><%=msg %></span> <br>
			<input type="checkbox" name="idCheck" value="idCheck" <%=checked %>>ID 기억 <br>
			<input type="submit" value="로그인">
		</form>
	</fieldset>
</body>
</html>