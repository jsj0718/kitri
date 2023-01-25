package oop5;

public class CalMain {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		double result1 = calc.add(10.5, 12.6);
		double result2 = calc.sub(5.2, 2.1);
		System.out.println(result1);
		System.out.println(result2);
	}

}
