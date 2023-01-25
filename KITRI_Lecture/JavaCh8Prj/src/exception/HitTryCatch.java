package exception;

public class HitTryCatch {

	public static void main(String[] args) {
		int hit = 0;
		
		try {
			System.out.println("�Խ��� �� Ŭ��");
			System.out.println("��ȸ�� ����");
			hit++;
			
			System.out.println("�Խ��� �� ��ȸ");
			System.out.println("���� �߻�");
			System.out.println(0/0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage().equals("/ by zero")) {
				System.out.println("0���� ���� �� �����ϴ�.");
			}
			hit--;
			System.out.println("���� ó�� �Ϸ�");
		}
		
		System.out.println("��ȸ�� :" + hit);
		System.out.println("�Խ��� ���� ȭ�鿡 ���");
		System.out.println("����ڰ� Ȯ��");
	}

}
