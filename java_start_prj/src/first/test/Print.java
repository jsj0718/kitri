package first.test;

class Print {
	public static void main(String args[]) {
		
		/*
		 * ----------------클래스 구조
		 * package : 현재 자바의 package 위치를 필수로 적는다.
		 * 예) first.test.Print.java
		 * 
		 * class : 클래스 파일 앞에 필수로 작성
		 * Print : 클래스의 이름 (앞에 문자는 대문자여야 한다.), 파일명과 클래스명이 동일해야 한다.
		 * public static void main(String[] args) {
		 * 	자바에서 처음 실행문을 실행하기 위해 필요함
		 * }
		 * ----------------콘솔 출력문
		 * System.out.print() : 출력 (내려쓰기 없음)
		 * System.out.println() : 출력 후 한줄 내려쓰기
		 * System.out.printf() : 형식 출력
		 * 
		 * \n : 한줄 내려쓰기 (개행문자)
		 */
		
		System.out.print("print-test");
		System.out.println();
		System.out.println("print-test 후 출력");		
		System.out.printf("%d값 출력, %s값 출력, %.1f값 출력 \n", 10, "정대만", 123.123);
		System.out.println("printf 후 출력");
		
		
		/*
		 * 클래스명 : PrintEx
		 * 기사제목 : -------
		 * 기사내용 : -------
		 * 기자 : ---
		 */
	}
}
