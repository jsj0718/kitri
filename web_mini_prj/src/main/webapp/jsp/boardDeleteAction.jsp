<%@page import="com.kitri.miniboard.board.BoardVO"%>
<%@page import="com.kitri.miniboard.board.BoardDAO"%>
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
	
	// bno가 null 또는 빈값이면 게시판으로 이동
	String bno = request.getParameter("bno");
	if (bno == null || bno.equals("")) {
		response.sendRedirect("board.jsp");
		return;
	}
	
	BoardDAO bdao = new BoardDAO();
	BoardVO bvo = bdao.selectBoardContent(Integer.parseInt(bno));
	
	// userId가 null이면 로그인창으로 이동
	String userId = (String) session.getAttribute("userId");
	if (userId == null) {
		response.sendRedirect("login.jsp");
		return;
	} else if (!userId.equals(bvo.getBwriter())) {
		response.sendRedirect("boardDetail.jsp?bno=" + bno);
		return;
	}
	
	
	int result = bdao.deleteBoard(Integer.parseInt(bno));
	if (result == 1) {
%>
	<script>
		alert("게시글 삭제 성공");
		location.href = "board.jsp";
	</script>
<%
	} else {
%>
	<script>
		alert("게시글 삭제 실패");
		location.href = "boardDetail.jsp?bno=" + bno;
	</script>
<%	
	}
	
%>


</body>
</html>