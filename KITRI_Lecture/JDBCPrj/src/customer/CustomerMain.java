package customer;

import java.util.ArrayList;

public class CustomerMain {
	public static void main(String[] args) {
		CustomerFunction cf = new CustomerFunction();
		ArrayList<CustomerVO> clist = new ArrayList<>();
		
		
		if(cf.insertCustomer(6, "����� ���ӽ�", "LA ����Ŀ��", "010-1234-5678") == 1) {
			System.out.println("INSERT �Ϸ�");
		} else {
			System.out.println("INSERT ����");
		}
		
		if(cf.updateCustomer(6, "ȫ�浿", "����", "016-123-4567") == 1) {
			System.out.println("UPDATE �Ϸ�");
		} else {
			System.out.println("UPDATE ����");
		}
		
		if(cf.deleteCustomer(6) == 1) {
			System.out.println("DELETE �Ϸ�");
		} else {
			System.out.println("DELETE ����");
		}
		
		clist = cf.selectCustomer();
		
		for(CustomerVO cvo : clist) {
			System.out.println(cvo.toString());
		}
		
		
		
	}
}
