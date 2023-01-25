package practice;

public class Ex1 {

	public static void main(String[] args) {
		// 1~10���� ���
		for (int i=1; i<=10; i++) {
			System.out.println(i);
		}
		System.out.println("--------");
		
		// 10~1���� ���
		for (int i=10; i>=1; i--) {
			System.out.println(i);
		}		
		System.out.println("--------");
		
		// 1~10���� ¦���� ���
		for (int i=1; i<=10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);				
			}
		}
		System.out.println("--------");
		
		// 1~10���� Ȧ���� ���
		for (int i=1; i<=10; i++) {
			if (i % 2 == 1) {
				System.out.println(i);				
			}
		}
		System.out.println("--------");
		
		// 1~10���� ���� ���
		int sum = 0;
		for (int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("����: " + sum);
		System.out.println("--------");
		
		// 1~10���� ���� ���
		for (int i=1; i<=10; i++) {
			if (i % 2 == 0) {
				System.out.print("* ");
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("--------");
		
		/*
		 * 11111
		 * 22222
		 * 33333
		 * 44444
		 * 55555
		 */
		
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		System.out.println("---------");
		
		/*
		 * 55555 
		 * 44444 
		 * 33333 
		 * 22222 
		 * 11111
		 */
		
		for (int i=5; i>=1; i--) {
			for (int j=1; j<=5; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println("---------");
		
		/*
		 * 1 2 3 4 5 
		 * 6 7 8 9 10 
		 * 11 12 13 14 15 
		 * 16 17 18 19 20
		 */
		
		for (int i=0; i<4; i++) {
			for (int j=1; j<=5; j++) {
				System.out.print(i * 5 + j + " ");
			}
			System.out.println();
		}
		System.out.println("---------");
		
		int[] arr = {4, 8, 10, 33, 6, 1, 12, 2, 13};
		
		// �ּҰ�
		int minVal = arr[0];
		for (int i=1; i<arr.length; i++) {
			if (minVal > arr[i]) {
				minVal = arr[i];
			}
		}
		System.out.println("�ּڰ�: " + minVal);
		System.out.println("---------");
		
		// 10���� ���� �� ���
		System.out.print("10���� ���� �� : ");
		for (int i=0; i<arr.length; i++) {
			if (arr[i] < 10) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
		System.out.println("---------");
		
		// ��պ��� ���� �� ���
		double sum1 = 0.0;
		for (int i=0; i<arr.length; i++) {
			sum1 += arr[i];
		}
		
		double avg = sum1 / arr.length;
		System.out.println("��հ�: " + Math.round(avg));
		System.out.print("��պ��� ���� �� ��� : ");
		for (int k : arr) {
			if (k < avg) {
				System.out.print(k + " ");
			}
		}
		System.out.println();
		System.out.println("-----------");
		
		// {4, 8, 10, 33, 6, 1, 12, 2, 13}
		// {8, 6, 12, 2, 33, 1, 13, 4, 20}  �� �迭�� �ٸ��� ã��
		int[] diffArr = {8, 6, 12, 2, 33, 1, 13, 4, 20};
		int[] idx = new int[arr.length];
		
		StringBuilder sb = new StringBuilder();
		System.out.print("���� �ٸ� �� ã�� : ");
		
		for (int k : diffArr) {
			for (int i=0; i<arr.length; i++) {
				if (arr[i] == k) {
					idx[i]++;
					break;
				}
				
				if (i == arr.length - 1) {
					sb.append("diffArr = ").append(k).append(", ");
				}
			}
		}
		
		for (int i=0; i<idx.length; i++) {
			if (idx[i] == 0) {
				sb.append("arr = ").append(arr[i]);
			}
		}
		System.out.println(sb);
		
		
		System.out.println();
		System.out.println("-----------");
		
	}

}
