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
			message(id + "님이 접속하였습니다.");
			String data = "";
			// 클라이언트가 보낸 값을 읽어서 모든 클라이언트한테 보내는 내용
			while ((data = dis.readUTF()) != null) {
				message(data);
			}
		} catch (IOException e) {
//			e.printStackTrace();
			message(id + "님이 떠났습니다.");
			MultiServer.socketList.remove(socket);
		}
	}
	
	public void message(String msg) {
		DataOutputStream dos = null;
		try {
			// 서버의 로그
			System.out.println(msg);
			// 클라이언트 소켓 리스트
			Set<Socket> keys = MultiServer.socketList.keySet();
			Iterator<Socket> it = keys.iterator();
			// 모든 클라이언트에게 메세지 전달
			while (it.hasNext()) {
				Socket key = it.next();
				// key는 맵에 담겨져 있는 소켓들
				// this.socket은 클라이언트 자신의 소켓
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
