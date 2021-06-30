package customer;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		CustomerFunction cf = new CustomerFunction();
		ArrayList<CustomerVO> clist = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("------------------------------");
			System.out.println("고객 정보 관리 시스템");
			System.out.println("1. 모든 고객 정보");
			System.out.println("2. 한 명의 고객 정보(번호)");
			System.out.println("3. 고객 정보 추가");
			System.out.println("4. 고객 정보 수정(번호)");
			System.out.println("5. 고객 정보 삭제(번호)");
			System.out.println("6. 종료");
			System.out.println("------------------------------");
			
			System.out.print("번호 입력: ");
			int check = sc.nextInt();
			sc.nextLine();
			
			if (check == 1) {
				clist = cf.selectCustomer();
				print(clist);
			} else if (check == 2) {
				System.out.print("고객 번호 입력: ");
				int custID = sc.nextInt();
				print(cf.selectCustomer(custID));
			} else if (check == 3) {
				System.out.print("고객 번호 입력: ");
				int custID = sc.nextInt();
				sc.nextLine();
				
				System.out.print("고객 이름 입력: ");
				String name = sc.nextLine();
				System.out.print("고객 주소 입력: ");
				String address = sc.nextLine();
				System.out.print("고객 전화번호 입력: ");
				String phone = sc.nextLine();
				
				if (cf.insertCustomer(custID, name, address, phone) == 1) {
					System.out.println("고객 정보 입력 완료");
				} else {
					System.out.println("고객 정보 입력 실패");
				}
				
			} else if (check == 4) {
				System.out.print("고객 번호 입력: ");
				int custID = sc.nextInt();
				sc.nextLine();
				System.out.print("수정할 고객 이름 입력: ");
				String name = sc.nextLine();
				System.out.print("수정할 고객 주소 입력: ");
				String address = sc.nextLine();
				System.out.print("수정할 고객 전화번호 입력: ");
				String phone = sc.nextLine();
				
				if (cf.updateCustomer(custID, name, address, phone) == 1) {
					System.out.println("고객 정보 수정 완료");
				} else {
					System.out.println("고객 정보 수정 실패");
				}
			} else if (check == 5) {
				System.out.print("고객 번호 입력: ");
				int custID = sc.nextInt();
				
				if (cf.deleteCustomer(custID) == 1) {
					System.out.println("고객 정보 삭제 완료");
				} else {
					System.out.println("고객 정보 삭제 실패");
				}
			} else if (check == 6) {
				break;
			}
			
		}
		sc.close();
	}
	
	public static void print(ArrayList<CustomerVO> clist) {
		for (CustomerVO cvo : clist) {
			System.out.println(cvo.toString());
		}
	}
	
	public static void print(CustomerVO cvo) {
		System.out.println(cvo.toString());
	}
}
