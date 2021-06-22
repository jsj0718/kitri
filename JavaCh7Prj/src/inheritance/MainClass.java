package inheritance;

public class MainClass {

	public static void main(String[] args) {
		// 부모 클래스
		A a = new A();
		
		a.varA = 100;
		a.methodA();
		
		// 자식 클래스
		B b = new B();

		b.strB = "자식클래스 변수";
		b.methodB();
		b.varA = 200;
		b.methodA();
	}

}
