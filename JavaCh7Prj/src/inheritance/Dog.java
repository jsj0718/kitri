package inheritance;

public class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("개가 짖는다.");
	}
	
	@Override
	void eat() {
		System.out.println("개가 먹는다.");
	}
	
	@Override
	void walk() {
		System.out.println("개가 걷는다.");
	}
	
	@Override
	void run() {
		System.out.println("개가 달린다..");
	}
}
