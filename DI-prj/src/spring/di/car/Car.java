package spring.di.car;

public interface Car {
	public void setT(Tire t);	// setter 이용한 DI 하기 위함
	public void turnOn();
	public void turnOff();
	public void runCar();
	public void breakCar();
}
