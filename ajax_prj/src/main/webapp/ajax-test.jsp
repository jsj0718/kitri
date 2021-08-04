<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		
		// 통신 X, 클라이언트 단에서 처리하는 로직
		var dataBtn = document.getElementById("dataBtn");
		dataBtn.onclick = function() {
			var dataBtn = document.getElementById("dataBtn");
			text.innerHTML = "데이터 수정됨";
		}
	
		// ajax Get방식 통신
		var ajaxGetBtn = document.getElementById("ajaxGetBtn");
		ajaxGetBtn.onclick = function() {
			//XMLHttpRequest 객체 생성
			var xhrget = new XMLHttpRequest();
			// ajax 방식 설정
			xhrget.open("GET", "ajax-server", true);
			// 요청 보내기
			xhrget.send();
			
			// 응답 성공
			xhrget.onreadystatechange = function() {
				
				if(xhrget.readyState == XMLHttpRequest.DONE && xhrget.status == 200) {
					// 응답 값 (서버로부터 받아온 데이터)
					var text = document.getElementById("text");
					text.innerHTML = xhrget.responseText;
				}
			}
		}
		
		var ajaxPostBtn = document.getElementById("ajaxPostBtn");
		ajaxPostBtn.onclick = function() {
			// XMLHttpRequest 객체 생성 (ajax 통신을 위한 객체)
			var xhrpost = new XMLHttpRequest();
			
			// 통신할 방식, url, 동기 여부 설정
			xhrpost.open("POST", "ajax-server", true);
			// post 요청을 하기 위한 header 세팅
			xhrpost.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			// 요청
			xhrpost.send("id=admin&name=관리자");
			
			// 응답
			xhrpost.onreadystatechange = function() {
				if(xhrpost.readyState == XMLHttpRequest.DONE && xhrpost.status == 200) {
					// 응답 값 (서버로부터 받아온 데이터)
					var jsonStr = xhrpost.responseText;	// json 형태의 문자열
					var json = JSON.parse(jsonStr);	// 문자열을 json으로 변환
					
					var jsonBox = document.getElementById("json-box");
					var html = "";
					for (var i=0; i<json.length; i++) {
						html += "<div> id : " + json[i].id + "<div>"
								+ "<div> name : " + json[i].name + "<div>";
					}
					jsonBox.innerHTML = html;
				}
			}
			
		}
	}
</script>
</head>
<body>
	<button id="ajaxGetBtn">ajax get 통신</button>
	<button id="ajaxPostBtn">ajax post 통신</button>
	<button id="dataBtn">데이터 수정</button>
	
	<div id="text"></div>
	<div id="json-box"></div>
</body>
</html>