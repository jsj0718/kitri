package array;

public class ArrayEx {
	public static void main(String[] args) {
		// �迭 �ȿ� �ִ� ��� ���� ����� ���϶�.
		int[] arr = {15, 66, 75, 24, 35};
		double sum = 0;
		
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		double avg = sum / arr.length;
		System.out.println("�迭�� ũ�� : " + arr.length);
		System.out.println("��� : " + avg);
		
		System.out.println("------------------");
		int[] arr1 = new int[] {99, 57, 23, 46, 16};
		
//		Ȧ��, ¦���� �հ�, ���
		
		int oddSum = 0;
		int evenSum = 0;
		int count = 0;
		for (int i=0; i<arr1.length; i++) {
			if (arr1[i] % 2 == 1) {
				oddSum += arr1[i];
				count++;
			} else {
				evenSum += arr1[i];
			}
		}
		
		double oddAvg =  (double) oddSum / count;
		double evenAvg = (double) evenSum / (arr1.length - count);
		
		System.out.printf("Ȧ�� �հ� : %d, ¦�� �հ� : %d\nȦ�� ��� : %.1f, ¦�� ��� %.1f\n"
				+ "Ȧ���� ���� : %d, ¦���� ���� : %d",
				oddSum, evenSum, oddAvg, evenAvg, count, (arr1.length - count));
		
		System.out.println();
		System.out.println("--------------------------");
		
		int[] arr2 = {75, 22, 36, 45, 88, 32, 16, 57, 95};
		int maxVal = arr2[0];
		
		for (int i=1; i<arr2.length; i++) {
			if (maxVal < arr2[i]) {
				maxVal = arr2[i];
			}
		}
		
		System.out.println(maxVal);
	}
}
