
public class VarCasting {

	public static void main(String[] args) {
		/*
		 * 형변환 (Casting)
		 *  - 기본 타입 형변환
		 *   1) String + all type : String으로 변환됨
		 *   2) 정수형 계산은 int 타입으로 반환
		 *     - 1 + 1 -> int
		 *     - byte b = 12;
		 *     - short s = 20;
		 *     - b + s = 32 (int 형)
		 *   
		 *   - 기본 타입 형변환 방법
		 *   long longVal = 1000;
		 *   int intVal = (int) d; // (변환할 타입) 변수명
		 *   ---------------
		 *   int intVal1 = 1000;
		 *   long longVal1 = (long)intVal1; // 작은 타입에서 큰 타입으로 들어갈 때는 캐스팅 생략 가능
		 */
		
		long longVal = 1000L;		
		int intVal = (int) longVal;
		System.out.println(intVal);
	
		int intVal1 = 1234;
		long longVal1 = intVal1;
		System.out.println(longVal1);
		
		float floatVal = 545.12f;
		int intVal2 = (int)floatVal;
		System.out.println(intVal2);
	}
}
