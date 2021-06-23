package interf;

public class MyData {

	static void myData(UserClass user) {
//		A instanceof B
//		A와 B가 같은 클래스이거나, 상속으로 연결된 클래스일 경우 true
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
