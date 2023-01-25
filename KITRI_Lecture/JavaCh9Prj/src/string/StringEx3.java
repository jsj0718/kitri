package string;

import java.util.HashMap;
import java.util.Iterator;

public class StringEx3 {
	public static void main(String[] args) {
		// 문제 1 (자바 관련 책 찾기)
		String[] strArr =  {"자바의 정석", "이것이 자바다", "혼자공부하는 자바", "이것이 오라클이다", "MY-SQL 정석"};
		
		for (String str : strArr) {
			if (str.contains("자바") || str.toLowerCase().contains("java")) {
				System.out.println("자바 관련 책 : " + str);
			}
		}
		System.out.println("--------------------------------");
		
		// 문제 2 (뉴스기사 100자만 출력후 뒤에는 ...찍기)
		String news = "[서울=뉴시스] 안경남 기자 = 크리스티아누 호날두가 A매치 통산 최다골 타이기록을 세운 가운데 포르투갈이 프랑스와 비기며 유럽축구선수권대회(유로2020) 16강에 합류했다."
				+ "\r\n"
				+ "포르투갈은 24일(한국시간) 헝가리 부다페스트의 푸스카스 아레나에서 치러진 유로2020 조별리그 F조 3차전에서 프랑스와 2-2 무승부를 거뒀다."
				+ "\r\n"
				+ "포르투갈은 호날두가 페널티킥으로 멀티골을 터트렸고, 프랑스는 카림 벤제마가 멀티골을 기록했다. 둘은 과거 레알 마드리드(스페인)에서 한솥밥을 먹었던 동료다."
				+ "\r\n"
				+ "이날 2골을 추가한 호날두는 이번 대회 3경기 연속골이자 대회 5호골로 득점 랭킹 단독 선두를 달렸다."
				+ "\r\n";
		
		if (news.length() > 100) {
			String news100 = news.substring(0, 99);
			System.out.println(news100 + "...");			
		} else {
			System.out.println(news);
		}
		System.out.println("--------------------------------");
		
		// 문제 3 (뉴스기사 마침표 개수 찾기)
		String reNews = news.replace(".", ". ");
		String[] newsArr = reNews.split("\\.");
		
		int cnt = newsArr.length - 1;
		
		System.out.println(".의 개수: " + cnt);
		System.out.println("--------------------------------");
		
		// 문제 4
		String reNews1 = news.replace("\r\n", " "); 
		String[] newsArr1 = reNews1.split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		
		for (String s : newsArr1) {
			if (s.endsWith("에서") || s.endsWith("으로") || s.endsWith("이자")) {
				s = s.substring(0, s.length()-2);
			}			
			if (s.endsWith("은") || s.endsWith("는") || s.endsWith("이") || s.endsWith("가") 
					|| s.endsWith("을") || s.endsWith("를") || s.endsWith("와") || s.endsWith("과")
					|| s.endsWith("의") || s.endsWith("로") || s.endsWith(".") || s.endsWith("로")) {
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
		    	System.out.println("단어:" + key + ", 횟수:" +  map.get(key));		    			    	
		    }
		}
		System.out.println("--------------------------------");
		
	}
}
