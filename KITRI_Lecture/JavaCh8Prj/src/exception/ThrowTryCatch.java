package exception;

public class ThrowTryCatch {
	public static void main(String[] args) {
		System.out.println("���α׷� ����");
//		boolean flag = false;
		
		try {
			method();
//			if (!flag) {
//				System.out.println("���� �߻�");
//				throw new Exception(); // ���� �߻�
//			}
		} catch (Exception e) {
			System.out.println("���� ó��");
			e.printStackTrace();
		}
		
		System.out.println("���α׷� ����");
		

	}

	
	public static void method() throws Exception {	// �߻��� ���ܸ� ������ ����
		System.out.println("method ����");
		try {
			System.out.println(0/0);	// ����			
		} catch (Exception e) {
			System.out.println("method ���� �߻�");
			throw new Exception();
		} finally {
			System.out.println("method ����");			
		}
	}
}
