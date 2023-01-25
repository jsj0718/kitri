package spring.di;

public class MainClass {
	public static void main(String[] args) {
		// 다형성 이용
//		A a = new A();
		
		// 생성자를 이용한 DI(의존성 주입)
		A a = new A(new B());
		
		// setter를 이용한 DI (의존성 주입)
		a.setI(new C());
//		A a = new A();
//		B b = new B();
//		C c = new C();
		
		a.print();
//		a.printA();
//		b.printB();
//		c.printC();
		
		
	}
}
