package exception;

public class TryCatch {
	
	public static void main(String args[]) {
		/*
		 * ����ó��: ����ó���� ������ �ƴ� ó�� ������ ���ܸ� ó���ϴ� ���� ���Ѵ�.
		 * ����: ���� ������ ������ ������ ���Ѵ�.
		 * 
		 * �����:
		 * try {
		 * 		���๮
		 * } catch (ó���� ����) {
		 * 		����ó����
		 * }
		 */
		
		System.out.println("����");
		try {
			int sum = 0;
			for (int i=1; i<=10; i++) {
				sum += i;
			}			
			System.out.println(sum);
			System.out.println(0/0);

		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch(Exception e) {	// Exception�� �ֻ��� ���� Ŭ����(��� ���� ó�� ����)
			e.printStackTrace();
//			e.getMessage();
			System.out.println("���� �߻�");
		
		System.out.println("����");
		}
	}
}
