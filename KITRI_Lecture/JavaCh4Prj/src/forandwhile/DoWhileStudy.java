package forandwhile;

public class DoWhileStudy {

	public static void main(String[] args) {
		/* 
		 * do - while �ݺ���
		 * 
		 * do {
		 * 
		 * 		* ������ �� �� ����
		 * 		1. ���๮
		 * } while (2. ���ǽ�);
		 * 
		 * 1 -> 2(t) -> 1 -> 2(t) -> 1 -> 2(f�� ����)
		 */
		
		int i = 0;
		int sum = 0;
		
		do {
			i++;
			sum += i;
		} while (i <= 10);
		
		System.out.println("�հ� : " + sum);
	}

}
