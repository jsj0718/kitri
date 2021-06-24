package string;

public class StringEx1 {
	
	public static void main(String[] args) {
		String str = "안녕 자바수업이야, java는 처음이지";
		char c = str.charAt(5);
		System.out.println(c);
		
		String[] strArr = {"991201-1234567", "200203-3457812", "850321-2923123", "920321-1230432"};
		for (String s : strArr) {
			if (s.charAt(7) == '1' || s.charAt(7) == '3') {
				System.out.println(s + " : " + "남자");
			} else if ((s.charAt(7) == '2' || s.charAt(7) == '4')) {
				System.out.println(s + " : " + "여자");
			}
		}
	}
}
