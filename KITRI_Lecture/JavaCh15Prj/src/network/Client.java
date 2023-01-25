package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		
		Scanner sc = null;
		Socket socket = null;
		try {
			// 클라이언트 소켓이 서버소켓으로 접속한다.
			socket = new Socket("192.168.0.213", 7777);
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			System.out.print("ID 입력: ");
			sc = new Scanner(System.in);
			String id = sc.nextLine();
			dos.writeUTF(id);
			dos.flush();
		
			System.out.println("접속 완료");
			
			// 채팅 receive
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			Thread sendThread = new Sender(socket);
			sendThread.start();
			
			while(dis != null) {
				// 계속 receive 상태 유지
				String data = dis.readUTF();
				System.out.println("서버: " + data);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
