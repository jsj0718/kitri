package oop4;

public class MethodClass2 {

	public static void main(String[] args) {
		MethodClass2 m2 = new MethodClass2();
		m2.printNumber1(10);
		m2.printNumber2(1, 50);
		// inputSum 반환타입이 int이기 때문에 그 값을 넣는 공간도 int여야 한다.
		int sum = m2.inputSum(1, 20);	// 1~20 합계 숫자
	}
	
	// 1~n까지 출력하는 메소드
	
	void printNumber1(int n) {
		for (int i=1; i<=n; i++) {
			System.out.print(i + " ");
		}
		// 같은 클래스 내에서 메소드 호출 방법 (static이 없다면 이름 그대로 사용 가능)
		printEnter();
	}
	
	// start부터 end까지 출력하는 메소드
	void printNumber2(int start, int end) {
		// start = 1, end = 50
		for (int i=start; i<=end; i++) {
			System.out.print(i + " ");
		}
		printEnter();
	}
	
	// 한줄 내려쓰고 "---------------" 구분해주는 메소드
	void printEnter() {
		System.out.println("\n-------------------");
	}
	
	// start ~ end까지 합계 값을 반환해주는 메소드
	int inputSum(int start, int end) {
		int sum = 0;
		for (int i=start; i<=end; i++) {
			sum += i;
		}
		return sum;
	}
}
