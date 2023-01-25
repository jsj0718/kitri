package oop4;

public class MethodClass3 {

	public static void main(String[] args) {
		MethodClass2 mc2 = new MethodClass2();	// MethodClass2의 공간을 생성
		mc2.printNumber1(10);
		
		int start = 10;
		int end = 30;
		
		int sum = mc2.inputSum(start, end);
		System.out.println(sum);
	}

}
