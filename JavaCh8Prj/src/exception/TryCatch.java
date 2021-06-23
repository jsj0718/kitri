package exception;

public class TryCatch {
	
	public static void main(String args[]) {
		/*
		 * 예외처리: 예외처리는 에러가 아닌 처리 가능한 예외를 처리하는 것을 말한다.
		 * 예외: 정상 실행이 가능한 에러를 말한다.
		 * 
		 * 사용방법:
		 * try {
		 * 		실행문
		 * } catch (처리할 예외) {
		 * 		예외처리문
		 * }
		 */
		
		System.out.println("시작");
		try {
			int sum = 0;
			for (int i=1; i<=10; i++) {
				sum += i;
			}			
			System.out.println(sum);
			System.out.println(0/0);

		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch(Exception e) {	// Exception은 최상위 예외 클래스(모든 예외 처리 가능)
			e.printStackTrace();
//			e.getMessage();
			System.out.println("예외 발생");
		
		System.out.println("종료");
		}
	}
}
