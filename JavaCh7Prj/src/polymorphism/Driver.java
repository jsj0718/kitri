package polymorphism;

public class Driver {
	static void drive(Car car) {
		car.run();
	}
	
	public static void main(String args[]) {
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		Truck truck = new Truck();
		
		drive(bus);
		drive(taxi);
		drive(truck);
	}
}
