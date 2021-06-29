package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			// 클라이언트 접속을 위한 서버소켓 생성 (방문 만들어주기)
			serverSocket = new ServerSocket(7777);
//			while (true) {
			System.out.println("접속 대기중...");
			
			// 클라이언트 접속 무한정 대기
			socket = serverSocket.accept();
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			String id = dis.readUTF();
			System.out.println(id + "님이 접속하였습니다.");				
//			}
			
			// send
			Thread sendThread = new Sender(socket);
			sendThread.start();
			
			// receive
			String data = "";
			while ((data = dis.readUTF()) != null) {
				System.out.println(id + ": " + data);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
