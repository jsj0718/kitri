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
			// Ŭ���̾�Ʈ ������ ���� �������� ���� (�湮 ������ֱ�)
			serverSocket = new ServerSocket(7777);
//			while (true) {
			System.out.println("���� �����...");
			
			// Ŭ���̾�Ʈ ���� ������ ���
			socket = serverSocket.accept();
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			String id = dis.readUTF();
			System.out.println(id + "���� �����Ͽ����ϴ�.");				
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
