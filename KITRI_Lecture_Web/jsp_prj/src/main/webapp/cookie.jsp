<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String idCheck = request.getParameter("idCheck");
	
	String msg = "";
	
	response.setContentType("text/html; charset=UTF-8");
	if (id.equals("admin") && pw.equals("1234")) {
		// 로그인 성공
		if (idCheck != null) {
			// ID 기억 O
			Cookie cookie = new Cookie("idCheck", id);
			cookie.setMaxAge(100);
			cookie.setPath("/");
			response.addCookie(cookie);
		} else {
			// ID 기억 X
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("idCheck")) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
		response.sendRedirect("login-ok.jsp");
	} else {
		// 로그인 실패
		msg = "ID 또는 password가 맞지 않습니다.";
		String url = "login.jsp?msg=" + URLEncoder.encode(msg, "UTF-8");
		response.sendRedirect(url);	// URI에 담겨가면서 한글 깨짐
		
		// request에 값 실어서 전송
// 		request.setAttribute("msg", msg);
		
// 		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
// 		rd.forward(request, response);
	}
%>