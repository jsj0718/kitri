<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 객체 생성 (서블릿에는 없기에 생성 필요, JSP는 내장객체가 존재하므로 그대로 사용 가능)
// 	HttpSession session = request.getSession();		// 세션 객체를 생성하기 위함 (JSessionID 가져오는 역할 (브라우저의 id))
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if (id.equals("admin") && pw.equals("1234")) {
		// 로그인 성공
		// 세션 값 생성
		session.setAttribute("id", id);
		response.sendRedirect("login-ok.jsp");		
	} else {
		// 로그인 실패
		response.sendRedirect("login-session.jsp");
	}
%>