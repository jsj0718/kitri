package spring.di.car;

public interface Car {
	public void setT(Tire t);	// setter �̿��� DI �ϱ� ����
	public void turnOn();
	public void turnOff();
	public void runCar();
	public void breakCar();
}
