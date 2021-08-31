package com.kitri.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
	
	// 소켓들을 유지할 Map을 선언
	private Map<String, WebSocketSession> socketList = new HashMap<String, WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 웹소켓 연결 시 동작
		// onopen
		System.out.println("afterConnection 실행");
		socketList.put(session.getId(), session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 웹소켓 클라이언트가 메시지 전송 시 동작
		// onmessage
		
		System.out.println("handleTextMessage 실행");
		System.out.println(message.getPayload());	// getPayload()를 통해 객체 내 String 값을 출력
		
		// Map에서 values()를 사용하면 순서가 있는 Collection으로 만들어준다.
		for (WebSocketSession userSession : socketList.values()) {
			userSession.sendMessage(message);
		}
		
//		session.sendMessage(message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 웹소켓 종료 시 동작
		// onclose
		System.out.println("afterConnectionClosed 실행");
		socketList.remove(session.getId());	// 새로고침 시 소켓 정보 초기화
	}
	
}
