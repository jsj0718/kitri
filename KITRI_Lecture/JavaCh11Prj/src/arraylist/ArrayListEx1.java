package arraylist;

import java.util.ArrayList;

public class ArrayListEx1 {
	public static void main(String[] args) {
		/*
		 * 1. List 
		 * - 순서 o, 값 중복 허용 o
		 * - 배열 단점을 보완
		 * - 크기가 가변적으로 변경될 수 있다.
		 * - 중간에 삭제가 이뤄지면 뒤에 배열공간이 앞당겨진다.
		 * 
		 * 종류
		 * 1) ArrayList, LinkedList, Vector, Stack
		 */
		
		String[] arr = new String[10];
		ArrayList<String> list = new ArrayList<>();
		
		// 값 넣기 (다른 타입은 배열에 잘 넣지 않는다.)
		list.add("문자값");
		list.add("문자1");
		list.add("문자2");
		list.add("문자3");
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
		
		list.set(3, "수정된 문자값");
		System.out.println(list);
		
		list.remove(list.size()-1);
		System.out.println(list);
		
//		list.clear();	// 전체 리스트 삭제
//		System.out.println(list);
		
		list.add(1, "문자0");
		System.out.println(list);
		
		int index = list.indexOf("문자1");
		System.out.println(index);
		System.out.println(list.get(index));
		list.set(index, "문자1-1");
		System.out.println(list);
		
		ArrayList<String> list2 = new ArrayList<>();
//		list2 = list;	// 주소값 복사
		list2.addAll(list);	// 값만 복사
		System.out.println(list2);
		
		list2.add("새로운 문자 추가");
		System.out.println(list);
		System.out.println(list2);
	}
}
