package string;

public class StringEx2 {
	public static void main(String[] args) {
		// contains
		
		String str = " 안녕 자바수업이야, java는 처음이지";
		
		System.out.println(str.contains("자바"));
		System.out.println(str.contains("오라클"));
		System.out.println("-----------------");
		
		// endsWith
		System.out.println(str.endsWith("지"));
		System.out.println(str.endsWith("이"));
		System.out.println(str.endsWith("음이지"));
		System.out.println(str.endsWith("처음이지"));
		System.out.println("-----------------");
		
		// equalsIgnoreCase
		String str1 = "java";
		String str2 = "Java";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println("-----------------");
		
		System.out.println(str.indexOf('a'));	// 12
		System.out.println(str.indexOf("수업"));	// 5
		
		System.out.println(str.lastIndexOf('a'));	// 14
		System.out.println(str.lastIndexOf("수업"));	// 5
		System.out.println("-----------------");
		
		// length
		System.out.println(str.length());
		System.out.println("-----------------");
		
		// replace
		
		String newStr = str.replace("java", "오라클");	// str은 수정되지 않음
		String newStr1 = str.replace(" ", "");
		System.out.println(str);
		System.out.println(newStr);
		System.out.println(newStr1);
		System.out.println("-----------------");
		
		// split
		String[] strArr = str.split(" ");
		for (String s : strArr) {
			System.out.println(s);
		}
		
		System.out.println("-----------------");
		String str5 = "홍길동 임꺽정 아이언맨 헐크 캡틴";
		String[] strArr1 = str5.split(" ");
		
		for (String s : strArr1) {
			System.out.println(s);
		}
		
		System.out.println("-----------------");
		
		// starsWith
		String str6 = str.trim();
		System.out.println(str6.startsWith("안녕"));
		System.out.println("-----------------");
		
		// subString
		String str7 = str.substring(4);
		System.out.println(str7);
		
		String str8 = str.substring(4, 10);
		System.out.println(str8);
		System.out.println("-----------------");
		String[] files = {"file1.txt", "파일1.hwp", "엑셀파일.xlsx", "자바파일.java", "test파일.csv"};
		
		for (String file : files) {
			System.out.println(file.substring(0, file.lastIndexOf('.')));
		}
		
		System.out.println("-------------");
		String str10 = "1100050";
		String str11 = "2148123";
		
		int a = Integer.parseInt(str10);
		int b = Integer.parseInt(str11);
		
		System.out.println(a + b);
	}
}
