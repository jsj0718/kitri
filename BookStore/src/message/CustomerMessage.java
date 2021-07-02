package message;

import java.io.Serializable;
import java.util.ArrayList;

import customer.CustomerVO;

// ����ȭ ����
public class CustomerMessage implements Serializable {
	// state - select, insert, update, delete
	private int state;
	
	// ����� - insert, update, delete : int / select : int
	private int result;
	
	// ���� ��ü
	private CustomerVO cvo;
	
	// ���� ��ü ����Ʈ
	private ArrayList<CustomerVO> clist;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public CustomerVO getCvo() {
		return cvo;
	}

	public void setCvo(CustomerVO cvo) {
		this.cvo = cvo;
	}

	public ArrayList<CustomerVO> getClist() {
		return clist;
	}

	public void setClist(ArrayList<CustomerVO> clist) {
		this.clist = clist;
	}
	
	
}
