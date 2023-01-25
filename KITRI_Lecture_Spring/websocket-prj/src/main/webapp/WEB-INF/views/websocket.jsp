<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	let webSocket;
	let id;

	window.onload = function() {
		const connect = document.getElementById("connect");
		connect.onclick = openWebSocket;
		
		const disconnect = document.getElementById("disconnect");
		disconnect.onclick = closeWebSocket;
		
		const msg = document.getElementById("msg");
		msg.onkeyup = sendMessage;
		const send = document.getElementById("send");
		send.onclick = sendMessage;
	}
	
	function sendMessage(event) {
		if (event.keyCode == 13 || event == PointEvent) {
			let msg = document.getElementById("msg");
			if (webSocket == null) {
				alert("채팅방에 입장하세요.");
				msg.value = "";
				return;
			}
			
			webSocket.send(id.value + ":" + msg.value);
			msg.value = "";
			msg.focus();			
		}
	}
	
	function closeWebSocket() {
		webSocket.send(id.value + "님이 접속을 종료하였습니다.");
		webSocket.close();
	}
	
	function openWebSocket() {
		id = document.getElementById("id");
		// id가 없는 경우 
		if (id.value == "") {
			alert("id를 입력하세요.")
			id.focus();
			return;
		}
		
		webSocket = new WebSocket("ws://192.168.0.213:8080/websocket/ws");	// 객체 생성까지 완료 (연결 필요), 핸들러와 끝에만(/ws) 동일하면 된다.
		webSocket.onopen = onOpen;
		webSocket.onmessage = onMessage;
		webSocket.onclose = onClose;
	}
	
	function onOpen() {
// 		alert(id.value+"님 환영합니다.");
		
		// msg 전달 -> handler -> handleTextMessage 호출
		webSocket.send(id.value+"님 환영합니다.");
	}
	
	function onMessage(event) {	// session.sendMessage(메세지 값) 호출되면 실행
		console.log(event);
// 		alert(event.data);
		const chatbox = document.getElementById("chatbox");
		chatbox.innerHTML += "<span>"+event.data+"</span> <br>";
		chatbox.scrollTop = chatbox.scrollHeight;	// 대화 시 스크롤 조정
	}
	
	function onClose() {
		alert("접속 종료");
	}
	
	

	
</script>
<style>
	#chatbox {
		width: 250px;
		height: 300px;
		border: 1px solid black;
		overflow: auto;
	}
</style>
</head>
<body>
	ID : <input type="text" name="id" id="id">
	<input type="button" id="connect" value="입장">
	<input type="button" id="disconnect" value="나가기">

	<h1>채팅창</h1>
	<div id="chatbox"></div>
	
	<input type="text" id="msg">
	<input type="button" id="send" value="전송">
</body>
</html>