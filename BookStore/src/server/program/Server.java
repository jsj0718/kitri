package server.program;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println("서버 대기중...");
			// 클라이언트 소켓 연결 대기
			Socket socket = serverSocket.accept();
			
			// 서버 핸들러 쓰레드 시작 (서버 핸들러 역할 : 클라이언트와 통신)
			Thread serverHandler = new ServerHandler(socket);
			serverHandler.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
