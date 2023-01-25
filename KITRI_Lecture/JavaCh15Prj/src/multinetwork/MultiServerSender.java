package multinetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;

public class MultiServerSender implements Runnable {
	private Socket socket;
	private String id;
	
	public MultiServerSender(Socket socket, String id) {
		this.socket = socket;
		this.id = id;
	}
	
	@Override
	public void run() {
//		DataOutputStream dos = null;
//		dos = MultiServer.dos;
				
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(socket.getInputStream());
			message(id + "���� �����Ͽ����ϴ�.");
			String data = "";
			// Ŭ���̾�Ʈ�� ���� ���� �о ��� Ŭ���̾�Ʈ���� ������ ����
			while ((data = dis.readUTF()) != null) {
				message(data);
			}
		} catch (IOException e) {
//			e.printStackTrace();
			message(id + "���� �������ϴ�.");
			MultiServer.socketList.remove(socket);
		}
	}
	
	public void message(String msg) {
		DataOutputStream dos = null;
		try {
			// ������ �α�
			System.out.println(msg);
			// Ŭ���̾�Ʈ ���� ����Ʈ
			Set<Socket> keys = MultiServer.socketList.keySet();
			Iterator<Socket> it = keys.iterator();
			// ��� Ŭ���̾�Ʈ���� �޼��� ����
			while (it.hasNext()) {
				Socket key = it.next();
				// key�� �ʿ� ����� �ִ� ���ϵ�
				// this.socket�� Ŭ���̾�Ʈ �ڽ��� ����
				if (key != this.socket) {
					dos = MultiServer.socketList.get(key);
					dos.writeUTF(msg);		
					dos.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
