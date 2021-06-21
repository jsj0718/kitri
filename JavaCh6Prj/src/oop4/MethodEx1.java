package oop4;

public class MethodEx1 {

	public static void main(String[] args) {
		MethodEx1 me1 = new MethodEx1();
		
		me1.printOddSum(10, 20);
		me1.printEvenOddSum(10, 20);
		int sum = me1.printInputSum(20, 10);
		System.out.println(sum);
		
		int[] arr = {20, 10, 30, 50, 40};
		int max = me1.maxValue(arr);
		System.out.println(max);
		
	}
	
	// 1~10까지 홀수의 합 출력 메소드 만들기
	void printOddSum(int a, int b) {
		int sum = 0;
		for (int i=a; i<b; i++) {
			if (i % 2 == 1) {
				sum += i;				
			}
		}
		System.out.println("홀수의 합 : " + sum);
	}
	
	// 1~10까지 짝수, 홀수의 합 출력 메소드 만들기
	void printEvenOddSum(int a, int b) {
		int evenSum = 0;
		int oddSum = 0;
		
		for (int i=a; i<=b; i++) {
			if (i % 2 == 0) {
				evenSum += i;				
			} else {
				oddSum += i;
			}
		}
		System.out.println("짝수의 합 : " + evenSum);
		System.out.println("홀수의 합 : " + oddSum);
	}
	
	// a, b를 받고 작은 수 ~ 큰 수까지의 합계 반환
	int printInputSum(int a, int b) {
		int sum = 0;
		if (a > b) {
			for (int i=b; i<=a; i++) {
				sum += i;
			}
		} else {
			for (int i=a; i<=b; i++) {
				sum += i;
			}
		}
		return sum;
	}
	
	// 입력 배열을 받고 최대값 출력
	int maxValue(int[] array) {
		int max = array[0];
		for (int i=1; i<array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		
		return max;
	}
}
