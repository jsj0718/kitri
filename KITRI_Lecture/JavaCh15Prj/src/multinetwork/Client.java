package multinetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static DataInputStream dis;
	public static DataOutputStream dos;
	
	public static void main(String[] args) {
		Socket socket = null;
		try {
			// ���� ����
			System.out.println("-------Ŭ���̾�Ʈ-------");
//			Scanner sc = new Scanner(System.in);
//			System.out.print("ID�� �Է��ϼ���.");
//			String id = sc.nextLine();
			
			ClientFrame cf = new ClientFrame();
			String id = cf.getId();
			
			socket = new Socket("192.168.0.235", 7777);
			System.out.println("���� ���� �Ϸ�");

			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			
			dos.writeUTF(id);
			dos.flush();
			
			Thread clientSenderT = new Thread(new ClientSender(id));
			Thread clientReceiverT = new Thread(new ClientReceiver(cf));
			
			clientSenderT.start();
			clientReceiverT.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
}
