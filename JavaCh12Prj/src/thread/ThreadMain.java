package thread;

public class ThreadMain {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		// ThreadEx1은 Thread 상속
		Thread t1 = new ThreadEx1(cal);
		// ThreadEx2는 Runnable 구현
		Thread t2 = new Thread(new ThreadEx2(cal));
//		Runnable r = new ThreadEx2();
//		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
		// 메인메소드도 하나의 쓰레드이므로 세 개의 쓰레드가 동시에 작동한다.
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
