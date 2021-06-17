package array;

public class ArrayEx {
	public static void main(String[] args) {
		// 배열 안에 있는 모든 값의 평균을 구하라.
		int[] arr = {15, 66, 75, 24, 35};
		double sum = 0;
		
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		double avg = sum / arr.length;
		System.out.println("배열의 크기 : " + arr.length);
		System.out.println("평균 : " + avg);
		
		System.out.println("------------------");
		int[] arr1 = new int[] {99, 57, 23, 46, 16};
		
//		홀수, 짝수의 합계, 평균
		
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
		
		System.out.printf("홀수 합계 : %d, 짝수 합계 : %d\n홀수 평균 : %.1f, 짝수 평균 %.1f\n"
				+ "홀수의 개수 : %d, 짝수의 개수 : %d",
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
