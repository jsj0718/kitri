package inheritance;

public class SmallCar extends Car{
	@Override
	void run() {
		System.out.println("SmallCar�� �޸���.");
	}
	
	@Override
	void stop() {
		System.out.println("SmallCar�� �����.");
	}
}
