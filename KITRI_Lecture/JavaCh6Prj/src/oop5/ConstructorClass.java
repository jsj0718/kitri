package oop5;

public class ConstructorClass {

	/*
	 * 생성자
	 * 	- 클래스 이름과 동일한 메소드이다.
	 * 	- 반환타입이 없다. 리턴도 없다.
	 * 	- 맨 처음에 객체화 진행 시 딱 한번만 실행
	 * 	- 입력변수는 개수, 타입 상관없이 입력 가능
	 * 	- 기본 생성자 "클래스명()"는 생략 가능
	 * 	  숨겨져 있기 때문에 생성자를 선언하지 않아도 기본 생성자가 호출된다.
	 * 	  단, 다른 형식으로 선언 후 기본 생성자를 선언하지 않으면 사용할 수 없기 때문에 이 때는 선언해야 한다.
	 * 	  예) 클래스명() -> 클래스명 변수명 = new 클래스명();
	 * 			- 생략이 되어도 가능
	 * 	
	 * 	- 생성자는 여러 개를 만들 수 있다. (입력 변수의 개수가 다르거나, 타입이 다른 경우) 
	 */
	
	// ConstructorClass() {} -> 숨겨져 있음
	// 단, 생성자를 하나라도 선언할 경우 기본 생성자는 삭제된다.

	// 생성자 사용
	ConstructorClass() {	// 클래스명 동일
		System.out.println("ConstructorClass 객체화 진행");
	}
	
	ConstructorClass(String s, int a, char c) {
		System.out.println("s : " + s);
		System.out.println("a : " + a);
		System.out.println("c : " + c);
	}
}
