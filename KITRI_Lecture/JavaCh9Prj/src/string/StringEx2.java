package string;

public class StringEx2 {
	public static void main(String[] args) {
		// contains
		
		String str = " �ȳ� �ڹټ����̾�, java�� ó������";
		
		System.out.println(str.contains("�ڹ�"));
		System.out.println(str.contains("����Ŭ"));
		System.out.println("-----------------");
		
		// endsWith
		System.out.println(str.endsWith("��"));
		System.out.println(str.endsWith("��"));
		System.out.println(str.endsWith("������"));
		System.out.println(str.endsWith("ó������"));
		System.out.println("-----------------");
		
		// equalsIgnoreCase
		String str1 = "java";
		String str2 = "Java";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println("-----------------");
		
		System.out.println(str.indexOf('a'));	// 12
		System.out.println(str.indexOf("����"));	// 5
		
		System.out.println(str.lastIndexOf('a'));	// 14
		System.out.println(str.lastIndexOf("����"));	// 5
		System.out.println("-----------------");
		
		// length
		System.out.println(str.length());
		System.out.println("-----------------");
		
		// replace
		
		String newStr = str.replace("java", "����Ŭ");	// str�� �������� ����
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
		String str5 = "ȫ�浿 �Ӳ��� ���̾�� ��ũ ĸƾ";
		String[] strArr1 = str5.split(" ");
		
		for (String s : strArr1) {
			System.out.println(s);
		}
		
		System.out.println("-----------------");
		
		// starsWith
		String str6 = str.trim();
		System.out.println(str6.startsWith("�ȳ�"));
		System.out.println("-----------------");
		
		// subString
		String str7 = str.substring(4);
		System.out.println(str7);
		
		String str8 = str.substring(4, 10);
		System.out.println(str8);
		System.out.println("-----------------");
		String[] files = {"file1.txt", "����1.hwp", "��������.xlsx", "�ڹ�����.java", "test����.csv"};
		
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
