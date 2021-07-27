<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
	#container {
		width: 500px;
		margin: 0 auto;
	}
	
	#title {
		text-align: center;
	}
</style>
</head>
<body>
	<div id="container">
		<h1 id="title">회원가입</h1>
		<form action="register" method="POST">
			<div class="form-group">
				<label for="id">ID</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요">
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> 
				<input type="password" class="form-control" id="password" name="password"
					placeholder="비밀번호">
			</div>
			<div class="form-group">
				<label for="passwordCheck">비밀번호 재확인</label> 
				<input type="password" class="form-control" id="passwordCheck" name="passwordCheck"
					placeholder="비밀번호 재확인">
			</div>
			<div class="form-group">
				<label for="name">이름</label> 
				<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="gender">성별</label> <br>
				<label> <input type="radio" name="gender" value="male"> 남 </label>
				<label> <input type="radio" name="gender" value="female"> 여 </label>
			</div>
			<div class="form-group">
				<label for="email">이메일 주소</label> 
				<input type="email" class="form-control" id="email" name="email"
					placeholder="이메일을 입력하세요">
			</div>
			<button type="submit" class="btn btn-default">제출</button>
		</form>
	</div>
</body>
</html>