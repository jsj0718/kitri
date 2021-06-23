package polymorphism;

public class Driver {
	static void drive(Car car) {
		car.run();
	}
	
	public static void main(String args[]) {
		Car car = new Bus();
		Car car1 = new Taxi();
		Car car2 = new Truck();
		
		drive(car);
		drive(car1);
		drive(car2);
	}
}
