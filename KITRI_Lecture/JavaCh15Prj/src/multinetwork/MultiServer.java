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
			// 클라이언트 접속을 위한 소켓 생성
			serverSocket = new ServerSocket(7777);
			System.out.println("-------서버-------");
			socketList = new HashMap<Socket, DataOutputStream>();
			
			while (true) {
				System.out.println("서버 접속 대기중...");
				// 클라이언트와 통신할 소켓 리턴 (무한정 대기했다가 클라이언트가 들어오면 소켓 리턴)
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
//				System.out.println(id + "님이 접속하였습니다.");
				System.out.println(socketList.size() + "명 접속");
				
				Thread multiSendT = new Thread(new MultiServerSender(socket, id));
				multiSendT.start();				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
