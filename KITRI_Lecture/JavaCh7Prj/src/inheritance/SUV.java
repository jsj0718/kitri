package inheritance;

public class SUV extends Car {
	@Override
	void run() {
		System.out.println("SUV�� �޸���.");
	}
	
	@Override
	void stop() {
		System.out.println("SUV�� �����.");
	}
}
