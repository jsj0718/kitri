package thread;

public class Calculator {
	int sum = 0;	// ���� ������ �����尡 ������ (���� ������ X)
	public synchronized void sum(int a, int b) {	// ����ȭ�� �Ͽ� �� �����尡 ����� �� �ٸ� �����尡 ������� ���ϰ� Lock�� ��
		sum = 0;
		for (int i=a; i<=b; i++) {
			try {
				Thread.sleep(100);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			sum += i;				
		}
		System.out.println("�հ� : " + sum);
	}
}
