package oop2;

public class MainClass {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		int a = 15;
		int b = 20;
		
		System.out.println(calc.add(a, b));	// ¥ı«œ±‚
		System.out.println(calc.minus(a, b));
		System.out.println(calc.multi(56, 27));
		System.out.println(calc.divide(a, b));
		
		System.out.println(calc.multi(calc.add(a, b), b));
	}

}
