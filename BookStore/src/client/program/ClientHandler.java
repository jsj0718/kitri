package client.program;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import client.frame.LoginFrame;
import message.CustomerMessage;

public class ClientHandler extends Thread{
	Socket socket;
	LoginFrame login;
	
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	
	public ClientHandler(Socket socket, LoginFrame login) {
		this.socket = socket;
		this.login = login;
	}
	
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			oos = new ObjectOutputStream(os);
			ois = new ObjectInputStream(is);
			
			CustomerMessage inMsg = null;
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				if (obj instanceof CustomerMessage) {
					inMsg = (CustomerMessage) obj;
					if (inMsg.getState() == 1) {
						login.join.idCheckOk(inMsg.getResult());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
