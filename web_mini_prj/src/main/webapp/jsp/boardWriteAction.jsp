<%@ page import="com.kitri.miniboard.board.BoardVO"%>
<%@ page import="com.kitri.miniboard.board.BoardDAO"%>
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
	request.setCharacterEncoding("UTF-8");

	// insert를 위해 값을 받아옴
	String btitle = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");
	String bwriter = (String) session.getAttribute("userId");
	
	BoardDAO bdao = new BoardDAO();
	
	int result = bdao.insertBoard(btitle, bwriter, bcontent);
	if (result == 1) {
%>
	<script>
		alert("게시글 등록 성공");
		location.href = "board.jsp";
	</script>
<%
	} else {
%>
	<script>
		alert("게시글 등록 실패");
		location.href = "boardWrite.jsp";
	</script>
<%	
	}
%>

</body>
</html>