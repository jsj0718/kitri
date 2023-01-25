package thread;

public class ThreadEx1 extends Thread {
	Calculator cal = null;
	
	public ThreadEx1(Calculator cal) {
		this.cal = cal;
	}
	@Override
	public void run() {
		// ������ 1�� ����
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
	 * ������
	 * - ���α׷� �ȿ��� �����ϴ� �ϲ� ���� (�޼ҵ�)
	 * - ��Ƽ������� ���� ���� �����尡 ���ÿ� ���� (��, ������ ���� ������ �ƴϴ�.)
	 * 
	 * ��� ���
	 * 1) ������ Ŭ���� ��� �Ǵ� �������̽� ����
	 * 2) run �޼ҵ� ���� (�������̵�)
	 * 3) ������ ����(��üȭ)
	 * 4) ������ start
	 * 
	 * ����)
	 * 1. ���
	 * 	MyThread extends Thread
	 * 	MyThread implements Runnable
	 * 
	 * 2. run ����
	 * 	MyThread extends Thread {
	 * 		public void run() {
	 * 			������ ���๮
	 * 		}
	 * 	}
	 * 
	 * 3. ���� �� ����
	 * 	class MainClass {
	 * 		main() {
	 * 			// 1) Thread Ŭ������ ��ӹ��� ���
	 * 			MyThread mt = new MyThread();
	 * 			mt.start();
	 * 
	 * 			// 2) Runnable �������̽��� ���(����)���� ���
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
