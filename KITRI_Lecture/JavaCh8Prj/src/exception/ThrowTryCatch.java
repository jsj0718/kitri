package exception;

public class ThrowTryCatch {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
//		boolean flag = false;
		
		try {
			method();
//			if (!flag) {
//				System.out.println("예외 발생");
//				throw new Exception(); // 예외 발생
//			}
		} catch (Exception e) {
			System.out.println("예외 처리");
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
		

	}

	
	public static void method() throws Exception {	// 발생한 예외를 상위로 던짐
		System.out.println("method 시작");
		try {
			System.out.println(0/0);	// 예외			
		} catch (Exception e) {
			System.out.println("method 예외 발생");
			throw new Exception();
		} finally {
			System.out.println("method 종료");			
		}
	}
}
