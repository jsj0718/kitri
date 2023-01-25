package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MapEx1 {
	public static void main(String[] args) {
		/*
		 * Map
		 * - key�� value�� ������ �ִ� �÷���
		 * - (key, value) ��Ʈ ����
		 * 
		 * - key�� ������ ���� �ߺ� ��� x
		 * - key�� set���� �����Ͽ� iterator�� ���� ������ �����, ���� �ְ� ��� ����
		 * 
		 * - value�� �ߺ� ��� o
		 * - value�� key�� ���� �˻� ����
		 * 
		 * ����
		 * HashMap<Key, Value> map = new HashMap<>();
		 * 
		 * // key�� value ��� generic�� ���� Ÿ�� ����
		 * HashMap<Ÿ��1, Ÿ��2> map = new HashMap<>();
		 * 
		 * map.put(key, value);	// ���� �Է� �� ����
		 * map.get(key);	=> value
		 */
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("myID", "admin");
		map.put("userID", "user");
		map.put("å �̸�", "ȥ����");
		
		Iterator<String> keys = map.keySet().iterator();
		
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println("Ű: " + key + ", ��: " + map.get(key));
		}
		
		HashMap<Integer, String> map2 = new HashMap<>();
		
		map2.put(0, "äġ��");
		map2.put(1, "����ȣ");
		map2.put(2, "���¿�");
		map2.put(3, "���븸");
		map2.put(4, "���¼�");
		
		for(int i=0; i<map2.size(); i++) {
			System.out.println(map2.get(i));
		}
	}
}
