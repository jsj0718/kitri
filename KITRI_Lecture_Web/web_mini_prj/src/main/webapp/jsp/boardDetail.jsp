<%@page import="com.kitri.miniboard.board.BoardVO"%>
<%@page import="com.kitri.miniboard.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<style>
	div.container {
		width: 800px;
		height: 700px;
		border: 1px solid black;
		
	}
	
	#input[type="text"], textarea {
		background-color: #D3D3D3;
	}
</style>

<script>
	function moveToBoard() {
		location.href = "board.jsp";
	}
	
	function deleteBoard() {
		var bno = document.getElementById("bno");
		var deleteFlag = confirm("삭제하시겠습니까?");
		if (deleteFlag) {
			location.href = "boardDeleteAction.jsp?bno=" + bno.value;
		}
	}
	
	function updateBoard() {
		var bno = document.getElementById("bno");
		location.href = "boardUpdate.jsp?bno=" + bno.value;
	}
	
	function back() {
		location.href = "board.jsp";
	}
</script>
</head>
<body>
<%
	String userId = (String) session.getAttribute("userId");

	String bno = request.getParameter("bno");
	if (bno == null || bno == "") {
		response.sendRedirect("board.jsp");	
	}

	BoardDAO bdao = new BoardDAO();
	BoardVO bvo = bdao.selectBoardContent(Integer.parseInt(bno));

%>
	<c:set var="bvo" value="<%=bvo %>"/>

	<div class="container">
		<h1 class="text-center">게시글 조회</h1>	
		<div class="form-group">
			<label for="bno">글 번호</label> 
			<input type="text" class="form-control" id="bno" name="bno" value="${bvo.bno }" readonly>
		</div>
		<div class="form-group">
			<label for="title">제목</label> 
			<input type="text"	class="form-control" id="btitle" name="btitle" value="${bvo.btitle }" readonly>
		</div>
		<div class="form-group">
			<label for="writer">작성자</label> 
			<input type="text" class="form-control" id="bwriter" name="bwriter" value="${bvo.bwriter }" readonly>
		</div>
		<div class="form-group">
			<label for="date">작성일</label> 
			<input type="text" class="form-control" id="bregDate" name="bregDate" value="${bvo.bregDate }" readonly>
		</div>
		<div class="form-group">
			<label for="content">내용</label> 
			<textarea class="form-control" id="bcontent" name="bcontent" rows="10" readonly>${bvo.bcontent }</textarea>
		</div>

		<c:if test="${!empty sessionScope.userId && userId eq bvo.bwriter }">
			<input type="button" class="btn btn-default" onclick="updateBoard();" value="수정">
			<input type="button" class="btn btn-default" onclick="deleteBoard();" value="삭제">		
		</c:if>
			<input type="button" class="btn btn-default" onclick="back();" value="글 목록">
	</div>
</body>
</html>