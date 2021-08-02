<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<style>
	div.container {
		width: 800px;
		height: 600px;
		border: 1px solid black;
		
	}
	
	#bwriter {
		background-color: #D3D3D3;
	}
</style>

<script>
	function moveToBoard() {
		location.href = "board.jsp";
	}
</script>
</head>
<body>
<%
	String userId = (String) session.getAttribute("userId");
	if (userId == null) {
		response.sendRedirect("login.jsp");		
	}
%>	
	<div class="container">
		<h1 class="text-center">게시글 작성</h1>
		<form action="boardWriteAction.jsp" method="POST">
			<div class="form-group">
				<label for="title">제목</label> 
				<input type="text"	class="form-control" id="btitle" name="btitle" placeholder="제목을 입력하세요" required>
			</div>
			<div class="form-group">
				<label for="writer">작성자</label> 
				<input type="text" class="form-control" id="bwriter" name="bwriter" placeholder="작성자를 입력하세요" value="<%=userId %>" readonly>
			</div>
			<div class="form-group">
				<label for="content">내용</label> 
				<textarea class="form-control" id="bcontent" name="bcontent" placeholder="내용을 입력하세요" rows="10" required></textarea>
			</div>
			<button type="submit" class="btn btn-default">제출</button>
			<input type="button" class="btn btn-default" onclick="moveToBoard();" value="취소">
		</form>
	</div>
</body>
</html>