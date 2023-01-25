package inheritance;

public class Cat extends Animal {
	@Override
	void sound() {
		System.out.println("����̰� ���.");
	}
	
	@Override
	void eat() {
		System.out.println("����̰� �Դ´�.");
	}
	
	@Override
	void walk() {
		System.out.println("����̰� �ȴ´�.");
	}
	
	@Override
	void run() {
		System.out.println("����̰� �޸���.");
	}
}
