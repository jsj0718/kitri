<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/login-style.css">
<script>
	window.onload = function() {
		var msg = document.getElementById("msg").value;
		if (msg != "") {
			alert(msg);
		}
		
		var join = document.getElementById("joinForm");
		// submit 발생 시 함수 실행
		join.onsubmit = function() {
			var pw = document.getElementById("join-pass").value;
			var pwOk = document.getElementById("join-pass-ok").value;
			
			if (pw == pwOk) {
				document.joinForm.action = "joinAction.jsp";	// action 값 설정
				document.joinForm.submit();						// 설정된 action으로 submit
			} else {
				alert("비밀번호가 동일하지 않습니다.");
				return;
			}
		}
	}
</script>
</head>
<body>
<%
	if (session.getAttribute("userId") != null) {
		session.removeAttribute("userId");
	}

	String userId = "";
	String idChecked = "";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("idCheck")) {
				userId = cookie.getValue();
				idChecked = "checked";
			}
		}
	}
	
// 	String msg = request.getParameter("msg");
// 	if (msg == null) {
// 		msg = "";
// 	}
	
	
%>
	<div class="login-wrap">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
			<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
			<div class="login-form">
				
				<input type="hidden" id="msg" value="${msg }">
				<form action="loginAction.jsp" method="POST">				
					<div class="sign-in-htm">
						<div class="group">
							<label for="userId" class="label">Username</label>
							<!-- ID 입력창 -->
							<input id="userId" type="text" class="input" name="userId" value="<%=userId %>" required>
						</div>
						<div class="group">
							<label for="userPw" class="label">Password</label>
							<!-- PW 입력창 -->
							<input id="userPw" type="password" class="input" data-type="password" name="userPw" required>
						</div>
						<div class="group">
							<!-- ID 기억 여부 -->
							<input id="check" type="checkbox" class="check" name="idCheck" value="Y" <%=idChecked %>>
							<label for="check"><span class="icon"></span> Keep me Signed in</label>
						</div>
						<div class="group">
							<input type="submit" class="button" value="Sign In">
						</div>
						<div class="hr"></div>
						<div class="foot-lnk">
							<a href="#forgot">Forgot Password?</a>
						</div>
					</div>
				</form>
				
				<!-- 회원가입 -->
				<form method="POST" name="joinForm" id="joinForm">
					<div class="sign-up-htm">
						<!-- id 입력 -->
						<div class="group">
							<label for="join-user" class="label">Username</label>
							<input id="join-user" type="text" class="input" name="join-userId" required>
						</div>
						<!-- pw 입력 -->
						<div class="group">
							<label for="join-pass" class="label">Password</label>
							<input id="join-pass" type="password" class="input" data-type="password" name="join-userPw" required>
						</div>
						<!-- pw 확인 입력 -->
						<div class="group">
							<label for="join-pass-ok" class="label">Repeat Password</label>
							<input id="join-pass-ok" type="password" class="input" data-type="password" required>
						</div>
						<!-- email 입력 -->
						<div class="group">
							<label for="join-email" class="label">Email Address</label>
							<input id="join-email" type="text" class="input" name="join-email" required>
						</div>
						<div class="group">
							<input type="submit" id="join-btn" class="button" value="Sign Up">
						</div>
						<div class="hr"></div>
						<div class="foot-lnk">
							<label for="tab-1">Already Member?</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>