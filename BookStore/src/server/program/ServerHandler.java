package server.program;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import customer.CustomerDAO;
import message.CustomerMessage;

// 쓰레드로 동작
public class ServerHandler extends Thread {
	Socket socket;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	
	public ServerHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			oos = new ObjectOutputStream(os);
			ois = new ObjectInputStream(is);
			
			CustomerDAO cdao = new CustomerDAO();
			CustomerMessage inMsg = null;
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				if (obj instanceof CustomerMessage) {
					inMsg = (CustomerMessage) obj;
					CustomerMessage outMsg = new CustomerMessage();
					// ID Check
					if (inMsg.getState() == 1) {
						int result = cdao.idCheck(inMsg.getCvo().getCustID());
						
						// state - idCheck에 대한 결과 값으로 1 입력
						outMsg.setState(1);
						
						// result
						outMsg.setResult(result);
						
						// writeObject
						oos.writeObject(outMsg);
						oos.flush();
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
