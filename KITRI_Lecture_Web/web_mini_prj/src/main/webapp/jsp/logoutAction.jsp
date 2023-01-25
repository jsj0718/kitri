<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String) session.getAttribute("userId");

	if (userId != null) {
		session.removeAttribute("userId");
	}

	response.sendRedirect("login.jsp");		
%>