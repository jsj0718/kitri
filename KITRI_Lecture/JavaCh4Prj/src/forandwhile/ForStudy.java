package forandwhile;

public class ForStudy {
	public static void main(String args[]) {
		/*
		 * for - �ݺ���
		 * 
		 * for(1.[�ʱ�ȭ��]; 2.���ǽ�; 3.������) {
		 * 		- �ʱ�ȭ���� ���� ����
		 * 		- ���ǽ��� true, false�� ����
		 * 		- ++, -- ������
		 * 
		 * 		3. ���๮
		 * }
		 * 
		 * 1. �ʱ�ȭ�� -> 2. ���ǽ� -> 3. ���๮ -> 4. ������
		 * ���� �� 2, 3, 4�� �ݺ��ȴ�. (2���� false�� ������ ����)
		 * 
		 * int i = 0;
		 * for (; i<10; i++) {
		 * 		���๮
		 * }
		 * 
		 * for(int i=0; i<10 && j<10; i++, j++) {
		 * 		���๮
		 * }
		 * 
		 * int i;
		 * for (i=1; i<10; i++) {
		 * 		���๮
		 * }
		 */
		
//		1~10������ ��
		int sum = 0;
		for (int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("1~10������ �հ�: " + sum);
		System.out.println("------------");
		
//		1~50���� �� 5�� ��� ������ �հ踦 ���϶�.
		int sum1 = 0;
		
		for (int i=1; i<=50; i++) {
			if (i % 5 == 0) {
				sum1+= i;
			}
		}
		
		System.out.println("1~50���� 5�� ��� �հ�: " + sum1);
		
		System.out.println("-------------");
		int sum2 = 0;
		
		for (int i=0; i<=100; i+=10) {
			sum2 += i;
		}
		
		System.out.println("1~100���� 10�� ��� �հ�: " + sum2);
		System.out.println("-------------");
		
		// ���� for��
		
		/*
		 * - 2�� for���� �ȿ� �մ� for������ ������ ���ϰ� �ۿ� �ִ� for�� ����
		 * 
		 * for (int i=0; i<=9; i++) {
		 * 		for (int k=0; k<=9; k++) {
		 * 			 ���๮
		 * 			- i=0, k=0
		 * 			 ���๮
		 *          - i=0, k=1 t
		 *           ���๮
		 *          - i=0, k=2 t .... k=9
		 *          ---------------------
		 *           ���๮
		 *          - i=1, k=0 t .... k=9
		 * 		}
		 * }
		 * 
		 */
		for (int i=2; i<=9; i++) {
			for (int j=1; j<=9; j++) {
				System.out.println(i + " X " + j + " = " + i * j);				
			}
			System.out.println("-------");
		}
		
//		5X5 �� �׸��� (1)
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("*");				
			}
			System.out.println();
		}
		System.out.println("------------");
		
//		�� �׸��� (2)
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("-------------");
//		�� �׸��� (3)
		for(int i=5; i>=1; i--) {
			for(int j=i; j>=1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
//		�� �׸��� (4)
		for(int i=1; i<=5; i++) {
			for(int j=5; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
