package inheritance;

public class MainClass {

	public static void main(String[] args) {
		// �θ� Ŭ����
		A a = new A();
		
		a.varA = 100;
		a.methodA();
		
		// �ڽ� Ŭ����
		B b = new B();

		b.strB = "�ڽ�Ŭ���� ����";
		b.methodB();
		b.varA = 200;
		b.methodA();
	}

}
