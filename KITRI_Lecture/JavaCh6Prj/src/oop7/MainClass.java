package oop7;

public class MainClass {

	static int var = 0;
	
	void methodTest() {
		var = 10;
	}

	public static void main(String[] args) {
		
		int var = 10;
		
		// ��üȭ ���� �� ���� ���
//		User user = new User();
//		System.out.println(user.a);
//		System.out.println(user.str);
		
		// static�� �̿��� ���� ��� (���Ÿ�ü�� ǥ����)
		System.out.println(User.a);
		System.out.println(User.str);
		
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		
		user1.a = 10;
		user1.str = "�����1";
		
		user2.a = 20;
		user2.str = "�����2";
		
		user3.a = 30;
		user3.str = "�����3";
		
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
