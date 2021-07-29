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
</style>
</head>
<body>
	<!-- 
	<div id="write-box">
		<div id="title">
			<span>제목</span>
			<input type="text" name="btitle">
		</div>
		
		<div id="writer">
			<span>작성자</span>
		</div>

		<div id="content">
			<span>내용</span>
			<textarea name="bcontent" rows="15" cols="50"></textarea>
		</div>
		
		<div>
			<button>저장</button>
			<button>취소</button>
		</div>
	</div>
	-->
	
	<div class="container">
		<h1 class="text-center">게시글 작성</h1>
		<form action="boardWriteAction.jsp" method="POST">
			<div class="form-group">
				<label for="title">제목</label> 
				<input type="text"	class="form-control" id="btitle" name="btitle" placeholder="제목을 입력하세요" required>
			</div>
			<div class="form-group">
				<label for="writer">작성자</label> 
				<input type="text" class="form-control" id="bwriter" name="bwriter" placeholder="작성자를 입력하세요" required>
			</div>
			<div class="form-group">
				<label for="content">내용</label> 
				<textarea class="form-control" id="bcontent" name="bcontent" placeholder="내용을 입력하세요" rows="10" required></textarea>
			</div>
			<button type="submit" class="btn btn-default">제출</button>
			<button type="reset" class="btn btn-default">취소</button>
		</form>
	</div>
</body>
</html>