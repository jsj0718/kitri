<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script>
// 	window.onload = function() {} 과 동일
// 	$(function() {});	// 방법 1

	// 방법 2
	$(document).ready(function(){
		// 방법 1. $("#loginBtn").onclick = function() {내용}
		// 방법 2. $("#loginBtn").onclick(function() {내용});
		$("#loginBtn").on("click", function() {
			let id = $("#id").val();
			let pw = $("#pw").val();
			
			if (id == "") {
				alert("아이디를 입력하세요.");
				return;
			}
			if (pw == "") {
				alert("비밀번호를 입력하세요.");
				return;
			}

			let user = new Object();
			user.id = id;
			user.pw = pw;
			
			$.ajax({
				url: "${pageContext.request.contextPath}/user/logincheck",	// 이동할 url 값
				type: "POST",	// method POST, GET
// 				data: {"id" : id, "pw" : pw},	// url로 이동시킬 데이터 값 (직접 객체로 만들어서 전송 가능)
				data: JSON.stringify(user),
				dataType: "json",	// 데이터 타입 설정 (json, xml)
				contentType: "application/json",
				success:function(data) {
					if (data) {
						window.location.replace("${pageContext.request.contextPath}/main");	// redirect는 replace()로 진행
					} else {
						$("#loginMsg")
// 							.attr("style", "color:red;")
							.css("color", "red")
							.css("font-size", "9px")
							.text("아이디 또는 패스워드가 틀립니다.")
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
	<h1>로그인</h1>
<%-- 	<form action="${pageContext.request.contextPath}/user/logincheck" method="post"> --%>
		<div>
			<input type="text" name="id" id="id" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="pw" id="pw" placeholder="비밀번호">
		</div>
		<div>
<!-- 			<input type="submit" value="제출"> -->
			<input type="button" id="loginBtn" value="로그인">
			<span id="loginMsg"></span>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/user/signup">회원 가입</a>
		</div>
<!-- 	</form> -->
	
	<!-- 네이버 아이디로 로그인 버튼 노출 영역 -->
	<div id="naver_id_login"></div>

	<!-- 네이버 아이디로 로그인 초기화 Script -->
	<script type="text/javascript">
		// 등록한 CliendID 값, 등록한 CallBack URL 값 넣기
		var naver_id_login = new naver_id_login("Y_OLZEll_4uCUDClS86b", "http://localhost:8080/mini/user/naverlogin");
		var state = naver_id_login.getUniqState();
		// 버튼 디자인 선택 가능 (white, green / 1, 2, 3)
		naver_id_login.setButton("green", 3, 40);
		// 로그인 창 도메인으로 설정
		naver_id_login.setDomain("http://localhost:8080/mini/user/login");
		naver_id_login.setState(state);
// 		naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();
	</script>
</body>
</html>