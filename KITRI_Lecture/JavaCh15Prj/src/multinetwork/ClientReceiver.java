package multinetwork;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientReceiver implements Runnable {
	private ClientFrame cf;
	
	public ClientReceiver(ClientFrame cf) {
		this.cf = cf;
	}
	
	@Override
	public void run() {
		DataInputStream dis = Client.dis;
		
		try {
			String data = "";
			while ((data = dis.readUTF()) != null) {
				// 클라이언트 콘솔
//				System.out.println(data);
				
				cf.putChatText(data);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
