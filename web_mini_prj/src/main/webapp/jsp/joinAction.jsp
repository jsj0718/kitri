<%@page import="java.net.URLEncoder"%>
<%@ page import="com.kitri.miniboard.member.MemberDAO"%>
<%@ page import="com.kitri.miniboard.member.MemberVO"%>
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
	String id = request.getParameter("join-userId");
	String pw = request.getParameter("join-userPw");
	String email = request.getParameter("join-email");
	
	MemberDAO mdao = new MemberDAO();
	
	String msg = "";
	// id 조회 성공 (가입 가능)
	if (mdao.selectMemberId(id) == null) {
		// 회원가입 - DB INSERT
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setEmail(email);
		
		int result = mdao.insertMember(mvo);
		if (result == 1) {
			// result = 1 (성공)
// 			msg = "회원가입에 성공했습니다.";
%>
	<script type="text/javascript">
		alert("회원가입에 성공했습니다.");
		location.href = "board.jsp";
	</script>			
<%
		} else {
			// result = 0 (실패)					
// 			msg = "회원가입에 실패했습니다. 다시 시도해주세요.";
			
%>
	<script type="text/javascript">
		alert("회원가입에 실패했습니다.");
		location.href = "login.jsp";
	</script>			
<%
		}
	// id 조회 실패 (가입 불가능)
	} else {
		// 중복된 ID
// 		msg = "이미 중복된 ID입니다.";
		
%>
	<script type="text/javascript">
		alert("이미 중복된 ID 입니다.");
		location.href = "login.jsp";
	</script>			
<%
	}
	
// 	String encodeMsg = URLEncoder.encode(msg, "UTF-8");
// 	response.sendRedirect("login.jsp?msg=" + encodeMsg);
%>
</body>
</html>