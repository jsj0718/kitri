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
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
	%>
	<div>
		java name : <%=name %> <br>
		java id : <%=id %> <br>

		<!-- parameter는 param을 꼭 붙여야한다. -->
		<!-- null이면 빈 공백으로 처리된다. -->
		name : ${param.name } <br>
		id : ${param.id } <br>
		
		${1+2 } <br>
		<!-- eq는 ==, ne는 != -->
		${param.name ne '정대만' }; <br>
	</div>
</body>
</html>