package multinetwork;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClientSender implements Runnable {
	private String id;
	
	public ClientSender(String id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		DataOutputStream dos = Client.dos;
		Scanner sc = new Scanner(System.in);

		try {	
			while(dos != null) {
				String data = sc.nextLine();
				dos.writeUTF("¡Ú" + id + "¡Ú" + data);							
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
