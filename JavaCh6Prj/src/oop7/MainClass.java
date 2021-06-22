package oop7;

public class MainClass {

	static int var = 0;
	
	void methodTest() {
		var = 10;
	}

	public static void main(String[] args) {
		
		int var = 10;
		
		// 객체화 진행 후 변수 사용
//		User user = new User();
//		System.out.println(user.a);
//		System.out.println(user.str);
		
		// static을 이용한 변수 사용 (이탤릭체로 표현됨)
		System.out.println(User.a);
		System.out.println(User.str);
		
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		
		user1.a = 10;
		user1.str = "사용자1";
		
		user2.a = 20;
		user2.str = "사용자2";
		
		user3.a = 30;
		user3.str = "사용자3";
		
		System.out.println("user1 : " + user1.a);
		System.out.println("user1 : " + user1.str);
		
		System.out.println("user2 : " + user2.a);
		System.out.println("user2 : " + user2.str);
		
		System.out.println("user3 : " + user3.a);
		System.out.println("user3 : " + user3.str);
		
		
		// static final
		System.out.println(User.NUMBER_TEN);
		System.out.println(User.GAME_START);
	}

}
