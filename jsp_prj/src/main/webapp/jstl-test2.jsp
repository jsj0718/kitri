<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> list = new ArrayList<>();
	list.add("문자1");
	list.add("문자2");
	list.add("문자3");
	list.add("문자4");
	
	// request의 Attribute를 설정
	request.setAttribute("list", list);
	
	// RequestDispatcher를 이용하여 전송
	RequestDispatcher rd = request.getRequestDispatcher("jstl-test.jsp");
	rd.forward(request, response);
%>