package string;

import java.util.HashMap;
import java.util.Iterator;

public class StringEx3 {
	public static void main(String[] args) {
		// ���� 1 (�ڹ� ���� å ã��)
		String[] strArr =  {"�ڹ��� ����", "�̰��� �ڹٴ�", "ȥ�ڰ����ϴ� �ڹ�", "�̰��� ����Ŭ�̴�", "MY-SQL ����"};
		
		for (String str : strArr) {
			if (str.contains("�ڹ�") || str.toLowerCase().contains("java")) {
				System.out.println("�ڹ� ���� å : " + str);
			}
		}
		System.out.println("--------------------------------");
		
		// ���� 2 (������� 100�ڸ� ����� �ڿ��� ...���)
		String news = "[����=���ý�] �Ȱ泲 ���� = ũ����Ƽ�ƴ� ȣ���ΰ� A��ġ ��� �ִٰ� Ÿ�̱���� ���� ��� ���������� �������� ���� �����౸�����Ǵ�ȸ(����2020) 16���� �շ��ߴ�."
				+ "\r\n"
				+ "���������� 24��(�ѱ��ð�) �밡�� �δ��佺Ʈ�� Ǫ��ī�� �Ʒ������� ġ���� ����2020 �������� F�� 3�������� �������� 2-2 ���ºθ� �ŵ״�."
				+ "\r\n"
				+ "���������� ȣ���ΰ� ���Ƽű���� ��Ƽ���� ��Ʈ�Ȱ�, �������� ī�� �������� ��Ƽ���� ����ߴ�. ���� ���� ���� ���帮��(������)���� �Ѽܹ��� �Ծ��� �����."
				+ "\r\n"
				+ "�̳� 2���� �߰��� ȣ���δ� �̹� ��ȸ 3��� ���Ӱ����� ��ȸ 5ȣ��� ���� ��ŷ �ܵ� ���θ� �޷ȴ�."
				+ "\r\n";
		
		if (news.length() > 100) {
			String news100 = news.substring(0, 99);
			System.out.println(news100 + "...");			
		} else {
			System.out.println(news);
		}
		System.out.println("--------------------------------");
		
		// ���� 3 (������� ��ħǥ ���� ã��)
		String reNews = news.replace(".", ". ");
		String[] newsArr = reNews.split("\\.");
		
		int cnt = newsArr.length - 1;
		
		System.out.println(".�� ����: " + cnt);
		System.out.println("--------------------------------");
		
		// ���� 4
		String reNews1 = news.replace("\r\n", " "); 
		String[] newsArr1 = reNews1.split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		
		for (String s : newsArr1) {
			if (s.endsWith("����") || s.endsWith("����") || s.endsWith("����")) {
				s = s.substring(0, s.length()-2);
			}			
			if (s.endsWith("��") || s.endsWith("��") || s.endsWith("��") || s.endsWith("��") 
					|| s.endsWith("��") || s.endsWith("��") || s.endsWith("��") || s.endsWith("��")
					|| s.endsWith("��") || s.endsWith("��") || s.endsWith(".") || s.endsWith("��")) {
				s = s.substring(0, s.length()-1);
			} 
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}
		
		Iterator<String> keys = map.keySet().iterator();
		
		while(keys.hasNext()){
		    String key = keys.next();
		    if (map.get(key) > 1) { 
		    	System.out.println("�ܾ�:" + key + ", Ƚ��:" +  map.get(key));		    			    	
		    }
		}
		System.out.println("--------------------------------");
		
	}
}
