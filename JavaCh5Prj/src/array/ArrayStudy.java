package array;

public class ArrayStudy {

	public static void main(String[] args) {
		
		/*
		 * Array - 배열 (다수의 연속적인 저장 공간)
		 * 
		 * -선언-
		 * 1.
		 * 데이터타입[] 변수명 = new 데이터타입[크기];	// 배열 공간에 default값 (0, null)
		 * 	예) float[] array = new float[5];	// 크기가 5인 float 배열
		 * 
		 * 2.
		 * 데이터타입 변수명[] = new 데이터타입[크기];
		 * 	예) String array[] = new String[6];	// 크기가 6인 String 배열
		 * 
		 * *****************************************************************
		 * 
		 * -초기화-
		 * 1. 
		 * 데이터타입[] 변수명 = new 데이터타입[크기];
		 * 변수명[0] = 값1;
		 * ....
		 * 변수명[크기-1] = 값n;
		 * 
		 * 예) int[] i = new int[5];
		 * 	   i[0] = 10;
		 *     i[1] = 20;
		 *     i[2] = 30;
		 *     i[3] = 40;
		 *     i[4] = 50;
		 * 
		 * 2.
		 * 데이터타입[] 변수명 = {값1, 값2, 값3, 값4};	// 크기가 4인 배열
		 *           변수명[0], 변수명[1], 변수명[2], 변수명[3]
		 *           
		 * 예) char[] array = {'a', 'b', 'c', 'd'};	// 크기가 4인 char 배열
		 * 
		 * 3. 
		 * 데이터타입[] 변수명 = new 데이터타입[] {값1, 값2, 값3, 값4};
		 * 예) String[] str = new String[] {"채치수", "강백호", "서태웅", "정대만", "송태섭"};	// 크기가 5인 String 배열
		 * 
		 * 
		 * 
		 */
		
		int[] arr = new int[5];
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
		System.out.println("-------------");
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("--------------");
		
		int[] arr1 = new int[5];
		for (int i=0; i<arr1.length; i++) {
			arr1[i] = (i+1) * 10;
			System.out.println(arr1[i]);
		}
	}

}
