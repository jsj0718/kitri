package customer;

import java.util.ArrayList;

public class CustomerMain {
	public static void main(String[] args) {
		CustomerFunction cf = new CustomerFunction();
		ArrayList<CustomerVO> clist = new ArrayList<>();
		
		
		if(cf.insertCustomer(6, "르브론 제임스", "LA 레이커스", "010-1234-5678") == 1) {
			System.out.println("INSERT 완료");
		} else {
			System.out.println("INSERT 실패");
		}
		
		if(cf.updateCustomer(6, "홍길동", "서울", "016-123-4567") == 1) {
			System.out.println("UPDATE 완료");
		} else {
			System.out.println("UPDATE 실패");
		}
		
		if(cf.deleteCustomer(6) == 1) {
			System.out.println("DELETE 완료");
		} else {
			System.out.println("DELETE 실패");
		}
		
		clist = cf.selectCustomer();
		
		for(CustomerVO cvo : clist) {
			System.out.println(cvo.toString());
		}
		
		
		
	}
}
