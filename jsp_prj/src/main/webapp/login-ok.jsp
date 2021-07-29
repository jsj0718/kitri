<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		var backBtn = document.getElementById("backBtn");
		backBtn.onclick = function() {
			history.back();
		}
		
		var logoutBtn = document.getElementById("logoutBtn");
		logoutBtn.onclick = function() {
			location.href = "logout.jsp";
		}
	}
</script>
</head>
<body>
	<h1>로그인 성공</h1>
	
	<%
		String id = (String) session.getAttribute("id");
		if (id == null) {
			id = "null";
		}
	%>
	<h2>session : <%=id %></h2>
	
	<button id="backBtn">뒤로 가기</button>
	<button id="logoutBtn">로그아웃</button>
</body>
</html>