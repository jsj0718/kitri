<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id");
	
	if (id != null) {
// 		session.removeAttribute("id");	// 하나의 세션 제거
		session.invalidate();	// 모든 세션 제거
	}
	
	response.sendRedirect("login-session.jsp");
%>