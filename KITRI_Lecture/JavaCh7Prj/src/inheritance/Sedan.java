package inheritance;

public class Sedan extends Car {
	@Override
	void run() {
		System.out.println("Sedan�� �޸���.");
	}
	
	@Override
	void stop() {
		System.out.println("Sedan�� �����.");
	}
}
