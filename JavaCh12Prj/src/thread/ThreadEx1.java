package thread;

public class ThreadEx1 extends Thread {
	Calculator cal = null;
	
	public ThreadEx1(Calculator cal) {
		this.cal = cal;
	}
	@Override
	public void run() {
		// 쓰레드 1번 동작
//		for (int i=0; i<300; i++) {
//			System.out.print("a");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
//		Calculator cal = new Calculator();
		cal.sum(1, 10);
	}
	
	/*
	 * 쓰레드
	 * - 프로그램 안에서 동작하는 일꾼 역할 (메소드)
	 * - 멀티쓰레드는 여러 개의 쓰레드가 동시에 동작 (단, 완전히 동시 동작은 아니다.)
	 * 
	 * 사용 방법
	 * 1) 쓰레드 클래스 상속 또는 인터페이스 구현
	 * 2) run 메소드 구현 (오버라이딩)
	 * 3) 쓰레드 선언(객체화)
	 * 4) 쓰레드 start
	 * 
	 * 예시)
	 * 1. 상속
	 * 	MyThread extends Thread
	 * 	MyThread implements Runnable
	 * 
	 * 2. run 구현
	 * 	MyThread extends Thread {
	 * 		public void run() {
	 * 			쓰레드 실행문
	 * 		}
	 * 	}
	 * 
	 * 3. 선언 및 실행
	 * 	class MainClass {
	 * 		main() {
	 * 			// 1) Thread 클래스를 상속받은 경우
	 * 			MyThread mt = new MyThread();
	 * 			mt.start();
	 * 
	 * 			// 2) Runnable 인터페이스를 상속(구현)받은 경우
	 * 			Runnable r = new MyThread();
	 * 			Thread t = new Thread(r);
	 * 			
	 * 			--> Thread t = new Thread(new MyThread());
	 * 		}
	 * 	}
	 * 
	 * 
	 */
	
	
	
}
