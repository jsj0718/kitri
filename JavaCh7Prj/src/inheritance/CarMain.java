package inheritance;

public class CarMain {

	public static void main(String[] args) {
		Sedan sedan = new Sedan();
		SUV suv = new SUV();
		SmallCar sc = new SmallCar();
		
		sedan.run();
		suv.run();
		sc.run();
	}

}
