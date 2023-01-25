package thread;

public class ThreadEx2 implements Runnable{
	Calculator cal = null;
	
	public ThreadEx2(Calculator cal) {
		this.cal = cal;
	}
	
	@Override
	public void run() {
		// 쓰레드 2번 동작
//		for(int i=0; i<300; i++) {
//			System.out.print("b");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
//		Calculator cal = new Calculator();
		cal.sum(1, 100);
	}

}
