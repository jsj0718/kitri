package oop4;

public class AccumMain {

	public static void main(String[] args) {
		AccumCalculator ac = new AccumCalculator();
		ac.add(10, 20);
		
		ac.add(10);
		ac.sub(20);
		ac.sub(-22);
		ac.add(100);
		
		System.out.println(ac.log);
		System.out.println(ac.totalSum);
		
		// 10 + 20 + 10 - 20 - (-22) + 100
		// 10 + 20 + 10 - 20 + 22 + 100
	}

}
