<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		const btn = document.getElementById("btn");		

		btn.onclick = function() {
			let id = document.getElementById("id");
			let pw = document.getElementById("pw");
			let name = document.getElementById("name");
			let email = document.getElementById("email");
			
			// json 변환
			let jsonForm = new Object;
			jsonForm.id = id.value;
			jsonForm.pw = pw.value;
			jsonForm.name = name.value;
			jsonForm.email = email.value;

			let json = JSON.stringify(jsonForm);
			console.log(json);
			
			// ajax
			let xhr = new XMLHttpRequest();
			xhr.open("POST", "reqbody", true);	// method, url, 비동기 여부
// 			xhr.setRequestHeader("Content-type", "application/x-www-from-urlencoded");	// post 방식으로 요청 시 헤더 설정
			xhr.setRequestHeader("Content-type", "application/json");	// post 방식으로 json 데이터 형식 요청 시 헤더 설정
			xhr.send(json);
			
			// 변화가 있을 때마다 함수 실행
			xhr.onreadystatechange = function() {
				if (xhr.readyState==XMLHttpRequest.DONE && xhr.status==200) {
					// 성공
// 					alert("성공");
					let jsonResult = xhr.responseText;
					console.log(jsonResult);
				}
			}
		}
	}
</script>
</head>
<body>
	<!-- form 대신 ajax로 데이터 전송 -->
	<form action="reqbody" method="post">
		아이디 : <input type="text" name="id" id="id"> <br>
		비밀번호 : <input type="password" name="pw" id="pw"> <br>
		이름 : <input type="text" name="name" id="name"> <br>
		이메일 : <input type="text" name="email" id="email"> <br>
		<input type="button" id="btn" value="전송">
	</form>
</body>
</html>