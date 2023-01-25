package client.program;

import java.io.IOException;
import java.net.Socket;

import client.frame.LoginFrame;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",7777);
			System.out.println("�������� �Ϸ�");
			
			LoginFrame login = new LoginFrame();
			
			//������ ����ϴ� Ŭ���̾�Ʈ �ڵ鷯 ������� ����
			Thread clientHandler = new ClientHandler(socket, login);
			clientHandler.start();
			
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
