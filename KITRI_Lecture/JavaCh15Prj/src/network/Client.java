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
			// Ŭ���̾�Ʈ ������ ������������ �����Ѵ�.
			socket = new Socket("192.168.0.213", 7777);
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			System.out.print("ID �Է�: ");
			sc = new Scanner(System.in);
			String id = sc.nextLine();
			dos.writeUTF(id);
			dos.flush();
		
			System.out.println("���� �Ϸ�");
			
			// ä�� receive
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			Thread sendThread = new Sender(socket);
			sendThread.start();
			
			while(dis != null) {
				// ��� receive ���� ����
				String data = dis.readUTF();
				System.out.println("����: " + data);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
