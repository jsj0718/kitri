<%@page import="java.net.URLEncoder"%>
<%@ page import="com.kitri.miniboard.member.MemberDAO"%>
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
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String idCheck = request.getParameter("idCheck");
	
	
	MemberDAO mdao = new MemberDAO();
	String result = mdao.selectMember(userId, userPw);
	
	Cookie cookie = new Cookie("idCheck", userId);
	
	if (idCheck == null) {
		idCheck = "N";
	}

	if (result != null) {
		// 로그인 성공 (세션, 쿠키)
		session.setAttribute("userId", userId);
		
		// 쿠키 확인
		if (idCheck.equals("Y")) {
			cookie.setMaxAge(60*60*24); // 1일
			cookie.setPath("/");
		} else {
			cookie.setMaxAge(0);		// 만료
			cookie.setPath("/");
		}
		
		response.addCookie(cookie);
		response.sendRedirect("board.jsp");
	} else {
		// 로그인 실패
		// 로그인 실패 문구
%>
	<script type="text/javascript">
		alert("아이디 또는 패스워드가 올바르지 않습니다.");
		location.href = "login.jsp";
	</script>
<%
		
// 		String msg = "아이디 또는 패스워드가 올바르지 않습니다.";
// 		String encodeMsg = URLEncoder.encode(msg, "UTF-8");
// 		response.sendRedirect("login.jsp?msg=" + encodeMsg);
	}
%>
</body>
</html>
