package oop7;

public class User {
	/*
	 * 1. final - 상수 선언 (변수, 메소드, 클래스)
	 * 		    - 변수는 값을 변경하지 못하게 만들어 하나의 값을 계속 유지
	 * 		      (숫자, 문자 가능)
	 * 		    - 상수 변수명은 무조건 대문자로 적는다. 여러 단어 합칠 때는 _로 합친다.
	 * 
	 * 예) final int NUMBER = 10;
	 * 	  final String START = "START";
	 * 
	 * 	  fianl String END;
	 * 
	 * 	  생성자() {
	 * 		END = "END";
	 * 	  }
	 * 
	 * 
	 * 2. static - 객체화를 진행하지 않고 사용할 수 있게 만드는 명령어
	 * 			 - 변수, 메소드에 사용 가능
	 * 
	 * 예) class A {
	 * 	  		static int number = 10;
	 * 	   }
	 * 
	 *    class B {
	 *           main() {
	 *           	A a = new A();	// x
	 *           	sysout(a.number);	// x
	 *           	
	 *           	sysout(A.number);	// o (단, 메모리 차지가 크기 때문에 가능하면 사용 X)
	 *           }
	 *    }
	 *    
	 * 3. static final - 어디든지 공통으로 사용 가능한 상수
	 * 				   - 보통 상수는 static final을 사용
	 * 
	 * 예) static final int NUMBER_TEN = 10;
	 *    static final String GAME_START = "START";
	 *    static final String GAME_END = "END";
	 *    
	 *    static final int NUMBER_TEN;
	 *    static {
	 *    		NUMBER_TEN = 초기값;
	 *    }
	 */
	
	final int NUMBER = 10;	// 상수
	final String START = "START";
	final String END = "END";
	
	void method() {
		System.out.println(NUMBER);
		System.out.println(START);
		System.out.println(END);
	}
	
	// static
	static int a = 10;
	static String str = "문자값";
	
	// static final (위치 바껴도 상관 X)
	final static int NUMBER_TEN = 10;
	static final String GAME_START = "START";
	
	
}
