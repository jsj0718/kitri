package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
	
	private Socket socket;
	
	// Socket √ ±‚»≠
	public Sender(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		OutputStream os = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			
			
			while (dos != null) {
				String data = sc.nextLine();
				dos.writeUTF(data);				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				dos.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
