package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MapEx1 {
	public static void main(String[] args) {
		/*
		 * Map
		 * - key와 value를 가지고 있는 컬렉션
		 * - (key, value) 세트 형식
		 * 
		 * - key는 순서가 없고 중복 허용 x
		 * - key는 set으로 변경하여 iterator를 통해 순서를 만들고, 순서 있게 출력 가능
		 * 
		 * - value는 중복 허용 o
		 * - value는 key를 통해 검색 가능
		 * 
		 * 사용법
		 * HashMap<Key, Value> map = new HashMap<>();
		 * 
		 * // key와 value 모두 generic을 통해 타입 지정
		 * HashMap<타입1, 타입2> map = new HashMap<>();
		 * 
		 * map.put(key, value);	// 값을 입력 및 수정
		 * map.get(key);	=> value
		 */
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("myID", "admin");
		map.put("userID", "user");
		map.put("책 이름", "혼공자");
		
		Iterator<String> keys = map.keySet().iterator();
		
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println("키: " + key + ", 값: " + map.get(key));
		}
		
		HashMap<Integer, String> map2 = new HashMap<>();
		
		map2.put(0, "채치수");
		map2.put(1, "강백호");
		map2.put(2, "서태웅");
		map2.put(3, "정대만");
		map2.put(4, "송태섭");
		
		for(int i=0; i<map2.size(); i++) {
			System.out.println(map2.get(i));
		}
	}
}
