package server.program;

import java.io.IOException;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(7777);
			
			System.out.println("���� ����");
			//Ŭ���̾�Ʈ ���Ͽ��� ���
			Socket socket = serverSocket.accept();
			System.out.println("Ŭ���ξ�Ʈ ����");
			//�����ڵ鷯 ������ ���� 
			//�����ڵ鷯 ������ Ŭ���̾�Ʈ�� ���
			Thread serverHandler = new ServerHandler(socket);
			serverHandler.start();
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
