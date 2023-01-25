package oop4;

// 클래스 이름 변경은 refactor -> rename으로 변경할 수 있다.
public class MethodClass {
	
	String str = "전역변수";
	
	// main 메소드
	// 자바 프로그램을 처음 실행해주는 메소드
	public static void main(String[] args) {
		/*
		 * 전역변수 : 클래스 바로 아래 쓰이는 변수 (전역변수, 멤버변수, 인스턴스변수)
		 * 		- 클래스 내에서 사용 가능 (메소드 상관 X)
		 * 		- 초기화가 자동으로 이루어짐
		 * 지역변수 : 메소드나 조건문, 반복문 안에서 쓰이는 변수
		 * 			{...} 안에서 동작
		 * 		- 메소드 내, 조건문/반복문 내에서 사용 가능
		 * 		- 초기화가 자동으로 이루어지지 않음
		 * 메소드 : 클래스 내에서 기능의 역할
		 * 		   (변수, 조건문, 반복문, 출력, 실행문 등)
		 * 
		 * 		- 사용 방법
		 * 			출력타입(반환타입) 메소드명(입력변수-개수 x, 타입 상관 x(기본타입, 참조타입[배열, String 등])) {
		 *          	실행문 // 중괄호 안에서 동작
		 *          } 
		 *          
		 *          예) 출력타입이 없는 메소드, 입력 하나
		 *          	void m1(int a) {
		 *          		// return 없음
		 *          	}
		 *          
		 *          	출력타입이 int, 입력이 두 개 (int, String)
		 *          	int m2(int a, String s) {
		 *          		// 출력타입이 있는 경우 return 필수
		 *          		return int타입의 변수
		 *          		or
		 *          		return 10;
		 *          	}
		 *          
		 *          	출력타입이 String, 입력이 하나 (int[])
		 *          	String m3(int[] array) {
		 *          		// 출력타입이 있는 경우 return 필수
		 *          		return String타입의 변수
		 *          		or
		 *          		return "값";
		 *          	}
		 *          
		 *          	이 때, 출력이 여러 개인 경우 배열을 이용한다.
		 * 
		 * static이 사용된 메소드 안에서는 객체화가 이루어져야 한다.
		 */
		
		String localStr = "지역변수1";
		
		MethodClass m1 = new MethodClass();	// 객체화
		m1.str = "전역변수 수정";
		System.out.println(m1.str);
		
		System.out.println(localStr);
		m1.function1();
	}
	
	void function1() {
		String localStr = "지역변수2";
		System.out.println(str);
		System.out.println(localStr);
	}
	
	// 반환타입 없고, 입력이 없는 메소드 (콘솔 출력, 계산 등)
	void method1() {	// 입력이 없는 경우 빈 괄호
		System.out.println("method1 출력");	// 출력문
		int a = 0;
		int b = 0;
		int sum = a + b;	// 메소드 내에서 계산이 끝나는 실행문
		
		str = "method1에서 전역변수 수정";
	}
	
	// 반환이 없고, 입력이 있는 메소드 
	void method2(String s) {
		// 입력을 받아서 처리(출력, 연산) 할 때 사용
		System.out.println(s + " 문자값 입력");	// 입력을 받아 출력
		s += " 수정된 문자값";	// 입력값을 수정
	}
	
	// 반환이 있고, 입력이 있는 경우 메소드
	String method3(int a, String s, int[] arr) {
		arr[0] = a;
		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
		String result = s + a;
		
		return result;
	}
	
	// 반환이 있고, 입력이 없는 경우 메소드
	int[] method4() {
		int[] result = new int[5];
		result[0] = 1;
		result[1] = 2;
		return result;
	}
}
