package forandwhile;

public class DoWhileStudy {

	public static void main(String[] args) {
		/* 
		 * do - while 반복문
		 * 
		 * do {
		 * 
		 * 		* 무조건 한 번 실행
		 * 		1. 실행문
		 * } while (2. 조건식);
		 * 
		 * 1 -> 2(t) -> 1 -> 2(t) -> 1 -> 2(f면 종료)
		 */
		
		int i = 0;
		int sum = 0;
		
		do {
			i++;
			sum += i;
		} while (i <= 10);
		
		System.out.println("합계 : " + sum);
	}

}
