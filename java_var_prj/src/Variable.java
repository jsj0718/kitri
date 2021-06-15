
public class Variable {

	public static void main(String[] args) {
		/*
		 * 변수 : 값을 저장하기 위한 공간
		 * 
		 * 변수 작성 방법 : 
		 * 1. 변수타입 변수명 = 초기화값;
		 * 2. 변수타입 변수명;
		 *    변수명 = 초기화값;
		 *    
		 *    예시) 1. int a = 0;
		 *         2. int a;
		 *            a = 0;
		 * 
		 * 변수 타입 종류
		 * 1. 기본 타입 (8개)
		 * 		- 논리 : boolean -> true, false
		 * 		- 문자 : char -> 'a' // 문자 하나 값
		 *                      ''  // 빈 값 안됨
		 * 		- 정수 : byte, short, int, long -> 정수값 (int 우선)
		 *                1     1     1    1L
		 * 		- 실수 : float, double -> 실수값 (double 우선)
		 *               1.1f   1.1
		 *               
		 * 		* ctrl + d : 한줄 삭제
		 * 
		 * 2. 참조 타입
		 * 		- 기본 타입을 제외한 나머지 (클래스 타입)
		 * 		- String
		 * 		* String 사용 방법 : String str = "문자열"; // 빈값, 문자열, null 가능
		 * 						   String str1 = "";
		 * 	                       String str2 = null;
		 */
		
		boolean flag = true;
		System.out.println("boolean 값 : " + flag);
		
		char c = 'a';	// 문자 하나 값
		System.out.println("char 값 : " + c);		
		
		int i = 123;
		System.out.println("char과 int의 합계 = " + c + i);
		
		float f = 12.59f;
		System.out.println("float 값 : " + f);
		System.out.println("--------------------------");
		String str1 = "문자열입니다.";
		String str2 = "";
		String str3 = null;
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		
		str1 = "null에서 변경";
		str2 = "변경된 문자";
		System.out.println(str1 + " " +str2);
		
		/*
		 * VariableEx
		 * 본인 소개
		 * 	- 이름
		 *  - 나이
		 *  - 키
		 *  - 학교
		 *  - 주소
		 *  - 핸드폰
		 *  - 번호 
		 */
	}

}
