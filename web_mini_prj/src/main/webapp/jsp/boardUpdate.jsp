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
	
	window.onload = function() {
		var saveBtn = document.getElementById("saveBtn");
		saveBtn.onclick = function() {
			var bno = document.getElementById("bno");
			location.href = "boardDetail.jsp?bno=" + bno.value;
		}
		
		var cancelBtn = document.getElementById("cancelBtn");
		cancelBtn.onclick = function() {
		}
	}
	
	function saveUpdate() {
		var updateFlag = confirm("수정하시겠습니까?");
		if (updateFlag) {
			document.updateForm.action = "boardUpdateAction.jsp";
			document.updateForm.method = "POST";
			document.updateForm.submit();
		}
	}
	
	function cancelUpdate() {
		var bno = document.getElementById("bno");
		location.href = "boardDetail.jsp?bno=" + bno.value;		
	}


</script>
</head>
<body>
<%
	String bno = request.getParameter("bno");
	if (bno == null || bno == "") {
		response.sendRedirect("board.jsp");	
	}

	BoardDAO bdao = new BoardDAO();
	BoardVO bvo = bdao.selectBoardContent(Integer.parseInt(bno));
	
	String userId = (String) session.getAttribute("userId");
	
	if (userId == null || !userId.equals(bvo.getBwriter())) {
		response.sendRedirect("boardDetail.jsp?bno=" + bvo.getBno());
		return;
	}

%>

	<c:set var="bvo" value=<%=bvo %>/>

	<div class="container">
		<h1 class="text-center">게시글 조회</h1>	
		<form name="updateForm">
			<div class="form-group">
				<label for="bno">글 번호</label> 
				<input type="text" class="form-control" id="bno" name="bno" value="${bvo.bno }" readonly>
			</div>
			<div class="form-group">
				<label for="title">제목</label> 
				<input type="text"	class="form-control" id="btitle" name="btitle" value="${bvo.btitle }" required>
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
				<textarea class="form-control" id="bcontent" name="bcontent" rows="10" required>${bvo.bcontent }</textarea>
			</div>
			<input type="button" class="btn btn-default" onclick="saveUpdate();" value="저장">
			<input type="button" class="btn btn-default" onclick="cancelUpdate();" value="취소">
		</form>
	</div>
</body>
</html>