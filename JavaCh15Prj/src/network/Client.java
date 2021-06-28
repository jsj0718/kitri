package network;

import java.io.DataOutputStream;
import java.io.IOException;
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
			socket = new Socket("192.168.0.235", 7777);
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			System.out.print("ID 입력: ");
			sc = new Scanner(System.in);
			String id = sc.nextLine();
			dos.writeUTF(id);
			dos.flush();
			System.out.println("접속 완료");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
