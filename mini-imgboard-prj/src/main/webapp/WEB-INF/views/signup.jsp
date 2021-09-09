<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@include file="header/header.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>	
	$(document).ready(function() {
		$("#signupBtn").on("click", function() {
			let id = $("#id");
			let pw = $("#pw");
			let name = $("#name");
			let email = $("#email");
			
			if (id.val() == "") {
				alert("아이디를 입력하세요.");
				id.focus();
				return;
			}
			if (pw.val() == "") {
				alert("비밀번호를 입력하세요.");
				pw.focus();
				return;
			} 
			if (name.val() == "") {
				alert("이름을 입력하세요.");
				name.focus();
				return;
			} 
			if (email.val() == "") {
				alert("이메일을 입력하세요.");
				email.focus();
				return;
			} 
			
			$.ajax({
				url: "${pageContext.request.contextPath}/user/idcheck",	// 이동할 url 값
				type: "POST",	// method POST, GET
				data: {"id" : id.val()},	// id에 파라미터 값이 담기게 된다. (value로 담아야 한다. -> 태그로 담아서 무한 호출함)
				dataType: "json",	// 데이터 타입 설정 (json, xml)
// 				contentType: "application/json",	// 이게 있으면 data 타입 인식을 못함 (받는 쪽에서 RequestBody를 써야함)
				success:function(data) {
					if (data) {
						$("#signupForm").submit();	// submit() 함수 호출 (submit은 안됨)
					} else {
						$("#idcheckMsg")
							.css("color", "red")
							.css("font-size", "9px")
							.text("이미 존재하는 회원입니다.")
					}									
				}, 
				error: function(request, status, error) {
					console.log("code: " + request.status);
					console.log("message: " + request.responseText);
					console.log("error: " + error);
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="${pageContext.request.contextPath}/user/signup-regist" method="POST" id="signupForm">
		<div>아이디: <input type="text" name="id" id="id" placeholder="아이디"><span id="idcheckMsg"></span></div>
		<div>비밀번호: <input type="password" name="pw" id="pw" placeholder="비밀번호"></div>
		<div>이름: <input type="text" name="name" id="name" placeholder="이름"></div>
		<div>이메일: <input type="email" name="email" id="email" placeholder="이메일"></div>
		<div><input type="button" id="signupBtn" value="회원가입"></div>
	</form>
</body>
</html>