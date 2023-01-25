package inheritance;

public class Cat extends Animal {
	@Override
	void sound() {
		System.out.println("고양이가 운다.");
	}
	
	@Override
	void eat() {
		System.out.println("고양이가 먹는다.");
	}
	
	@Override
	void walk() {
		System.out.println("고양이가 걷는다.");
	}
	
	@Override
	void run() {
		System.out.println("고양이가 달린다.");
	}
}
