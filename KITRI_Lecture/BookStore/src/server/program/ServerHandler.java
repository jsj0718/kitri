package server.program;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import book.BookDAO;
import book.BookVO;
import customer.CustomerDAO;
import message.BookMessage;
import message.CustomerMessage;
import message.OrdersMessage;
import orders.OrdersDAO;
import orders.OrdersVO;

public class ServerHandler extends Thread {

	Socket socket;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;

	public ServerHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		try {

			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream(); 

			ois = new ObjectInputStream(in);
			oos = new ObjectOutputStream(out);

			CustomerMessage inCMsg = null;
			BookMessage inBMsg = null;
			OrdersMessage inOMsg = null;
//			CustomerMessage outMsg = null;
			Object obj = null;
			
			while ((obj = ois.readObject()) != null) {
				if (obj instanceof CustomerMessage) {
					inCMsg = (CustomerMessage) obj;
					CustomerMessage outMsg = new CustomerMessage();
					CustomerDAO cdao = new CustomerDAO();
					if (inCMsg.getState() == 1) { // id �ߺ�üũ
						String id = inCMsg.getCvo().getCustId();
						int result = cdao.idCheck(id);

						// state - idcheck�� ���� ��� ������ 1�Է�
						outMsg.setState(1);
						// result
						outMsg.setResult(result);
						// writeObject
						oos.writeObject(outMsg);
						oos.flush();

					} else if (inCMsg.getState() == 2) { // ȸ������
						outMsg = new CustomerMessage();

						int result = cdao.insertCustomer(inCMsg.getCvo());
						outMsg.setState(2);
						outMsg.setResult(result);
						oos.writeObject(outMsg);
						oos.flush();
					} else if (inCMsg.getState() == 3) { // �α���
						outMsg = new CustomerMessage();
						int result = cdao.login(inCMsg.getCvo());
						outMsg.setState(3);
						outMsg.setResult(result);
						oos.writeObject(outMsg);
						oos.flush();

					}
				} else if (obj instanceof BookMessage) {
					inBMsg = (BookMessage) obj;
					BookMessage outMsg = new BookMessage();
					BookDAO bdao = new BookDAO();
					if (inBMsg.getState() == 1) { // å ����Ʈ ��ȸ
						ArrayList<BookVO> blist = bdao.selectAllBook();
						outMsg.setState(1);
						outMsg.setBlist(blist);
						oos.writeObject(outMsg);
						oos.flush();
					}

				} else if (obj instanceof OrdersMessage) {
					inOMsg = (OrdersMessage) obj;
					OrdersMessage outMsg = new OrdersMessage();
					OrdersDAO odao = new OrdersDAO();
					if (inOMsg.getState() == 1) { // �ֹ� ����Ʈ ��ȸ
						String custId = inOMsg.getOvo().getCustId();
						ArrayList<OrdersVO> olist = odao.selectOrder(custId);
						outMsg.setState(1);
						outMsg.setOlist(olist);
						oos.writeObject(outMsg);
						oos.flush();
					}else if (inOMsg.getState() == 2) { // �ֹ� 
						OrdersVO ovo = inOMsg.getOvo();
						int result = odao.insertOrders(ovo);
						outMsg.setState(2);
						outMsg.setOvo(ovo);
						outMsg.setResult(result);
						oos.writeObject(outMsg);
						oos.flush();
					}else if (inOMsg.getState() == 3) { // �ֹ���� 
						OrdersVO ovo = inOMsg.getOvo();
						int result = odao.deleteOrders(ovo.getOrderId());
						outMsg.setState(3);
						outMsg.setResult(result);
						oos.writeObject(outMsg);
						oos.flush();
					}

				} 
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
