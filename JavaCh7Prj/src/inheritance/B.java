package inheritance;

public class B extends A {	// A클래스를 상속 받은 B클래스
	/*
	 * 상속 - 부모 클래스 변수, 메소드를 자식 클래스에서 쓸 수 있음
	 * 
	 * 예) class B extends A // A: 부모클래스, B: 자식클래스
	 * 
	 * 오버라이딩(OverWriting) 
	 * - 부모클래스의 메소드를 자식클래스에서 재정의함
	 * - 메소드명, 매개변수 개수/타입/리턴타입이 같아야 한다.
	 * - 자식클래스에서 재정의 하지 않으면 부모클래스 메소드를 호출
	 * 	 하지만, 자식클래스에서 재정의하면 자식클래스 메소드를 호출
	 * 
	 * 예) 
	 * 	class A
	 * 		void method() {
	 * 			sysout("부모클래스 메소드");
	 * 		}
	 * 
	 *	class A extends B
	 * 		void method() {
	 * 			sysout("자식클래스 재정의 메소드");
	 * 		}	
	 */
	
	String strB;
	
	void methodB() {
		System.out.println("method B");
	}
	
	void methodA() {
		System.out.println("method A 재정의");
	}
}
