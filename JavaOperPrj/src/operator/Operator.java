package operator;

public class Operator {

	public static void main(String[] args) {
		/*
		 * 증감 : ++, --
		 * 	- 1씩 증가, 감소
		 * 	- ++변수 (전위) : 참조하기 전에 증감
		 *  - 변수++ (후위) : 참조 후 증감
		 *  
		 * 나머지 : %
		 * 	- num1 % num2 : num1을 num2로 나눠서 남은 값
		 * 
		 * 비교 : ==(같다), !=(다르다)
		 * 	- var1 == var2 : var1과 var2가 같으면 true, 다르면 false
		 *  - var1 != var2 : var1과 var2가 다르면 true, 같으면 false
		 * 
		 * 논리 : &&(and), ||(or)
		 * 	- var1 && var2 : var1과 var2가 둘 다 true일 때만 true, 나머지는 false
		 *  - var1 || var2 : var1과 var2가 둘 다 false일 때만 false, 나머지는 true
		 *  
		 * 삼항 연산자 (조건문) : (조건식) ? 값1(true) : 값2(false)
		 * 	- (조건식)이 true일 때 값1이 호출, false일 때 값2가 호출
		 * 
		 */
		
		int i = 0;
		int result = 0;
//		i++;	// i++, ++i, i--, --i를 단독으로 쓸 때는 증감 역할만 한다.
//		++i;
		
		result = ++i;
//		result = i++;
//		++i;
//		i++;
		
		System.out.println("result = " + result);
		System.out.println("i = " + i++);
		
		System.out.println("------------------");
		
		System.out.println("비교 (==) : " + (10 == 10));
		System.out.println("비교 (!=) : " + (20 != 20));
		
		System.out.println("------------------");
		
		int num1 = 10;
		int num2 = 4;
		
		int resultRemain = num1 % num2;
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("나머지 값: " + resultRemain);
		
		System.out.println("num1 짝수 : " + (num1%2 == 0));
		System.out.println("num1 홀수 : " + (num1%2 != 0));
		
//		논리
		boolean flag1 = true;
		boolean flag2 = false;
		
		System.out.println("flag1 && flag2 : " + (flag1 && flag2));
		System.out.println("flag1 || flag2 : " + (flag1 || flag2));
		
//		삼항 연산자
		int input = 24357862;
		String resultStr1 = (input % 2 == 0) ? "짝수" : "홀수";
		String resultStr2 = (input % 3 == 0) ? "3의 배수 O" : "3의 배수 X";
		
		System.out.println("홀짝 여부 : " + resultStr1);
		System.out.println("3의 배수 여부 : " + resultStr2);
		
		int var1 = 0;
		int var2 = 0;
		
		String resultStr3 = (var1 > var2) ? "var1이 크다" : ((var1 < var2) ? "var2가 크다" : "var1과 var2가 같다");
		System.out.println(resultStr3);
	}

}
