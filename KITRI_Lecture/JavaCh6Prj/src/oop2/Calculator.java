package oop2;

public class Calculator {
	/*
	 * 속성 : 출력화면 Size
	 * 기능 : 더하기, 빼기, 곱하기, 나누기 등
	 * 
	 */
	
	String printSize = "";
	
	// 더하기
	int add(int a, int b) {
		int result = a + b;
		return result;
	}
	
	// 빼기
	int minus(int a, int b) {
		int result = a - b;
		return result;
	}
	
	// 곱하기
	int multi(int a, int b) {
		int result = a * b;
		return result;
	}
	
	// 나누기
	double divide(int a, int b) {
		double result = (double) a / b;
		return result;
	}
}
