package oop5;

public class Calculator {
	/*
	 * 메소드 오버로딩
	 * 	- 메소드명이 같은 메소드를 만들 수 있다.
	 * 	- 조건: 1.메소드명이 같고, 2.입력변수(매개변수) 타입이 다르거나, 3.개수가 다를 경우
	 * 	- 리턴타입은 상관 X
	 */
	
	// 더하기 오버로딩
	int add(int a, int b) {
		return a + b;
	}
	
	double add(int a, double b) {
		return a + b;
	}
	
	double add(double a, int b) {
		return a + b;
	}
	
	double add(double a, double b) {
		return a + b;
	}
	
	// 빼기 오버로딩
	int sub(int a, int b) {
		return a - b;
	}
	
	double sub(int a, double b) {
		return a - b;
	}
	
	double sub(double a, int b) {
		return a - b;
	}
	
	double sub(double a, double b) {
		return a - b;
	}
	
}
