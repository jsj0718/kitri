package array;

public class ArrayStudy {

	public static void main(String[] args) {
		
		/*
		 * Array - �迭 (�ټ��� �������� ���� ����)
		 * 
		 * -����-
		 * 1.
		 * ������Ÿ��[] ������ = new ������Ÿ��[ũ��];	// �迭 ������ default�� (0, null)
		 * 	��) float[] array = new float[5];	// ũ�Ⱑ 5�� float �迭
		 * 
		 * 2.
		 * ������Ÿ�� ������[] = new ������Ÿ��[ũ��];
		 * 	��) String array[] = new String[6];	// ũ�Ⱑ 6�� String �迭
		 * 
		 * *****************************************************************
		 * 
		 * -�ʱ�ȭ-
		 * 1. 
		 * ������Ÿ��[] ������ = new ������Ÿ��[ũ��];
		 * ������[0] = ��1;
		 * ....
		 * ������[ũ��-1] = ��n;
		 * 
		 * ��) int[] i = new int[5];
		 * 	   i[0] = 10;
		 *     i[1] = 20;
		 *     i[2] = 30;
		 *     i[3] = 40;
		 *     i[4] = 50;
		 * 
		 * 2.
		 * ������Ÿ��[] ������ = {��1, ��2, ��3, ��4};	// ũ�Ⱑ 4�� �迭
		 *           ������[0], ������[1], ������[2], ������[3]
		 *           
		 * ��) char[] array = {'a', 'b', 'c', 'd'};	// ũ�Ⱑ 4�� char �迭
		 * 
		 * 3. 
		 * ������Ÿ��[] ������ = new ������Ÿ��[] {��1, ��2, ��3, ��4};
		 * ��) String[] str = new String[] {"äġ��", "����ȣ", "���¿�", "���븸", "���¼�"};	// ũ�Ⱑ 5�� String �迭
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
