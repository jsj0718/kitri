package oop1;

public class MainClass {

	public static void main(String[] args) {
		// void : ��ȯ���� ���� �Լ� Ÿ��
		// main : �ڹٿ��� �������ִ� �Լ�
		
		Car carA = new Car();	// Car �ϳ��� ����
		carA.carName = "Sonata";
		System.out.println(carA.brand);
		System.out.println(carA.carName);
		
		carA.doStartUp();
		carA.accelator();
		carA.carBreak();
		
		String info = carA.carInfo("Ford", "Explorer", 4000, "auto");
		System.out.println("�귣��\t���̸�\t����(cc)\t���");
		System.out.println(info);

		System.out.println("---------------");
		Car carB = new Car();
		carB.carName = "Avante";
		System.out.println(carB.brand);
		System.out.println(carB.carName);
		System.out.println(carB.engine);
		
		carB.doStartUp();
		carB.accelator();
		carB.carBreak();
	}

	public void a() {
	}
}
