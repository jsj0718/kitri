package interf;

public class MyData {

	static void myData(UserClass user) {
//		A instanceof B
//		A�� B�� ���� Ŭ�����̰ų�, ������� ����� Ŭ������ ��� true
		if (user instanceof InfoMenu) {
			user.userInfo();			
		}
	}
	
	public static void main(String args[]) {
		myData(new IndiUser());
		myData(new BusinessUser());
		myData(new Guest());
	}
}
