package thread;

public class Calculator {
	int sum = 0;	// 전역 변수만 쓰레드가 공유함 (지역 변수는 X)
	public synchronized void sum(int a, int b) {	// 동기화를 하여 한 쓰레드가 사용할 때 다른 쓰레드가 사용하지 못하게 Lock을 검
		sum = 0;
		for (int i=a; i<=b; i++) {
			try {
				Thread.sleep(100);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			sum += i;				
		}
		System.out.println("합계 : " + sum);
	}
}
