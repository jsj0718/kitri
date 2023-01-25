package thread;

public class ThreadMain {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		// ThreadEx1�� Thread ���
		Thread t1 = new ThreadEx1(cal);
		// ThreadEx2�� Runnable ����
		Thread t2 = new Thread(new ThreadEx2(cal));
//		Runnable r = new ThreadEx2();
//		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
		// ���θ޼ҵ嵵 �ϳ��� �������̹Ƿ� �� ���� �����尡 ���ÿ� �۵��Ѵ�.
//		for(int i=0; i<300; i++) {
//			try {
//				Thread.sleep(50);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			System.out.print("M");
//		}
	}

}
