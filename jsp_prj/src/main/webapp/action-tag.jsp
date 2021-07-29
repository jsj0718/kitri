<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- forward, include, param 액션 태그 --%>
	<h1>Action-Tag Page</h1>
	
	<%--
	<%
		// forward와 같은 구조 
		RequestDispatcher rd = request.getRequestDispatcher("next-page.jsp");
		rd.forward(request, response);
	%>
	<jsp:forward page="next-page.jsp"></jsp:forward>
	--%>
	
	<%
		String str = "action-tag 변수";
	%>

	<%-- next-page.jsp 파일의 모든 내용(태그)을 action-tag.jsp에 포함시켜서 렌더링 (필요없는 부분을 제외해야 한다.)--%>
	<%-- include 지시자는 HTML 파일을 모두 가져와서 넣어주는 역할, 서로 다른 페이지지만 변수 공유로 데이터 유지 가능 --%>
<%-- 	<%@ include file="next-page.jsp" %> --%>
	
	<%-- include 액션 태그는 렌더링된 내용을 가져와서 넣어주는 역할 --%>
<%-- 	<jsp:include page="next-page.jsp"></jsp:include> --%>
	
	<h1>Action-Tag Page 하단</h1>
	<h2><%=str %></h2>
</body>
</html>