package multinetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MultiServer {
//	public static DataInputStream dis = null;
//	public static DataOutputStream dos = null;
	
	public static HashMap<Socket, DataOutputStream> socketList;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		DataInputStream dis;
		DataOutputStream dos;
		try {
			// Ŭ���̾�Ʈ ������ ���� ���� ����
			serverSocket = new ServerSocket(7777);
			System.out.println("-------����-------");
			socketList = new HashMap<Socket, DataOutputStream>();
			
			while (true) {
				System.out.println("���� ���� �����...");
				// Ŭ���̾�Ʈ�� ����� ���� ���� (������ ����ߴٰ� Ŭ���̾�Ʈ�� ������ ���� ����)
				Socket socket = null;
				synchronized(MultiServer.class) {
					socket = serverSocket.accept();					
				}
				
				
//				InputStream is = socket.getInputStream();
//				OutputStream os = socket.getOutputStream();
				
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				socketList.put(socket, dos);
				
				String id = dis.readUTF();				
//				System.out.println(id + "���� �����Ͽ����ϴ�.");
				System.out.println(socketList.size() + "�� ����");
				
				Thread multiSendT = new Thread(new MultiServerSender(socket, id));
				multiSendT.start();				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
