<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- set은 변수 선언 -->
	<!-- var(변수명), value(실제값) -->
	<c:set var="name" value="${param.name}"/>
	
	<!-- remove는 변수 지우기 -->
<%-- 	<c:remove var="name"/> --%>
	
	<!-- EL 표현식으로 출력 -->
	name : ${name } <br>
	
	<!-- out은 출력 (escape 등을 설정할 수 있다.)-->
	<!-- <>는 HTML에서 태그로 인식하므로 out을 사용하지 않으면 출력되지 않음 (out을 사용하면 출력 가능) -->
	<!-- script 입력을 문자 그대로 인식해주므로 적용되지 않는다. -->
	id : <c:out value="${param.id }" escapeXml="true"/> <br>
	
	<%-- if문 --%>
	<c:if test="${name == 'jdm' }">
		true 출력
	</c:if>
	
	<br>
	
	<%-- if ~ else if ~ else문 --%>
	<c:choose>
		<c:when test="${name eq '정대만' }">true1</c:when> <%-- if문 --%>
		<c:when test="${name eq '강백호' }">true2</c:when> <%-- else if문 --%>
		<c:otherwise>false</c:otherwise> <%-- else문 --%>
	</c:choose>
	
	<br>
	
	<%-- for문, null이여도 공백처리를 하여 null pointer Exception 발생 X --%>
	<c:forEach var="str" items="${requestScope.list }" varStatus="status">
		${str }, ${status.index } <br>
	</c:forEach>
	
	<%-- 위와 동일한 구문, null일 경우 null pointer Exception 발생 O --%>
<%--
	ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");
	for (String str : list) {
--%>
<%-- 		<%=str %> <br> --%>
<%--
	}
--%>

	<c:forEach begin="1" end="10" var="i" step="1" varStatus="status">
		${i }, ${status.begin }, ${status.end } <br>
	</c:forEach>

<%
	Date now = new Date();
%>
	<fmt:formatDate value="<%=now %>" pattern="yyyy-MM-dd HH:mm:ss" />
</body>
</html>