package spring.di;

public class MainClass {
	public static void main(String[] args) {
		// ������ �̿�
//		A a = new A();
		
		// �����ڸ� �̿��� DI(������ ����)
		A a = new A(new B());
		
		// setter�� �̿��� DI (������ ����)
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
