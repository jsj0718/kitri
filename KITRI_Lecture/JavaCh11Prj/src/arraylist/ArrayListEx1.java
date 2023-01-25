package arraylist;

import java.util.ArrayList;

public class ArrayListEx1 {
	public static void main(String[] args) {
		/*
		 * 1. List 
		 * - ���� o, �� �ߺ� ��� o
		 * - �迭 ������ ����
		 * - ũ�Ⱑ ���������� ����� �� �ִ�.
		 * - �߰��� ������ �̷����� �ڿ� �迭������ �մ������.
		 * 
		 * ����
		 * 1) ArrayList, LinkedList, Vector, Stack
		 */
		
		String[] arr = new String[10];
		ArrayList<String> list = new ArrayList<>();
		
		// �� �ֱ� (�ٸ� Ÿ���� �迭�� �� ���� �ʴ´�.)
		list.add("���ڰ�");
		list.add("����1");
		list.add("����2");
		list.add("����3");
//		list.add(1234);
//		list.add(true);
//		list.add(10.5f);
		
		System.out.println(list);
		
//		String str = (String) list.get(0);
//		int var = (int) list.get(1);
//		boolean flag = (boolean) list.get(2);
//		float fvar = (float) list.get(3);
		
//		System.out.println(str);
//		System.out.println(var);
//		System.out.println(flag);
//		System.out.println(fvar);
		
//		for (int i=0; i<list.size(); i++) {
//			String str = list.get(i) + "hi";
//			System.out.println(str);
//		}
		
		list.set(3, "������ ���ڰ�");
		System.out.println(list);
		
		list.remove(list.size()-1);
		System.out.println(list);
		
//		list.clear();	// ��ü ����Ʈ ����
//		System.out.println(list);
		
		list.add(1, "����0");
		System.out.println(list);
		
		int index = list.indexOf("����1");
		System.out.println(index);
		System.out.println(list.get(index));
		list.set(index, "����1-1");
		System.out.println(list);
		
		ArrayList<String> list2 = new ArrayList<>();
//		list2 = list;	// �ּҰ� ����
		list2.addAll(list);	// ���� ����
		System.out.println(list2);
		
		list2.add("���ο� ���� �߰�");
		System.out.println(list);
		System.out.println(list2);
	}
}
