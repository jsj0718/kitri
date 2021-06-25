package set;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx1 {
	public static void main(String[] args) {
		/*
		 * set 
		 * - 중복 x, 순서 x
		 * - 검색을 위해 iterator 사용
		 * - HashSet 많이 사용
		 * 
		 * set 사용법
		 * - 값을 넣을 때 add() 사용
		 * 
		 * 
		 * iterator 사용법 (값을 검색)
		 * - hasNext() 사용해서 set에 값이 있는지 없는지 확인
		 * - 값이 있으면 next() 사용하여 값을 가져옴
		 */
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("안녕");
		set.add("졸리다");
		set.add("왜 안풀리냐");
		set.add("화가 난다.");
		set.add("Hello");
		set.add("안녕");
		set.add("안녕1");
		
		Iterator<String> list = set.iterator();
		
		while (list.hasNext()) {
			System.out.println(list.next());
		}
		
	}
}
