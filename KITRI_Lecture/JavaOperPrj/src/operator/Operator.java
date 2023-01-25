package operator;

public class Operator {

	public static void main(String[] args) {
		/*
		 * ���� : ++, --
		 * 	- 1�� ����, ����
		 * 	- ++���� (����) : �����ϱ� ���� ����
		 *  - ����++ (����) : ���� �� ����
		 *  
		 * ������ : %
		 * 	- num1 % num2 : num1�� num2�� ������ ���� ��
		 * 
		 * �� : ==(����), !=(�ٸ���)
		 * 	- var1 == var2 : var1�� var2�� ������ true, �ٸ��� false
		 *  - var1 != var2 : var1�� var2�� �ٸ��� true, ������ false
		 * 
		 * �� : &&(and), ||(or)
		 * 	- var1 && var2 : var1�� var2�� �� �� true�� ���� true, �������� false
		 *  - var1 || var2 : var1�� var2�� �� �� false�� ���� false, �������� true
		 *  
		 * ���� ������ (���ǹ�) : (���ǽ�) ? ��1(true) : ��2(false)
		 * 	- (���ǽ�)�� true�� �� ��1�� ȣ��, false�� �� ��2�� ȣ��
		 * 
		 */
		
		int i = 0;
		int result = 0;
//		i++;	// i++, ++i, i--, --i�� �ܵ����� �� ���� ���� ���Ҹ� �Ѵ�.
//		++i;
		
		result = ++i;
//		result = i++;
//		++i;
//		i++;
		
		System.out.println("result = " + result);
		System.out.println("i = " + i++);
		
		System.out.println("------------------");
		
//		System.out.println("�� (==) : " + (10 == 10));
//		System.out.println("�� (!=) : " + (20 != 20));
		
		System.out.println("------------------");
		
		int num1 = 10;
		int num2 = 4;
		
		int resultRemain = num1 % num2;
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("������ ��: " + resultRemain);
		
		System.out.println("num1 ¦�� : " + (num1%2 == 0));
		System.out.println("num1 Ȧ�� : " + (num1%2 != 0));
		
//		��
		boolean flag1 = true;
		boolean flag2 = false;
		
		System.out.println("flag1 && flag2 : " + (flag1 && flag2));
		System.out.println("flag1 || flag2 : " + (flag1 || flag2));
		
//		���� ������
		int input = 24357862;
		String resultStr1 = (input % 2 == 0) ? "¦��" : "Ȧ��";
		String resultStr2 = (input % 3 == 0) ? "3�� ��� O" : "3�� ��� X";
		
		System.out.println("Ȧ¦ ���� : " + resultStr1);
		System.out.println("3�� ��� ���� : " + resultStr2);
		
		int var1 = 0;
		int var2 = 0;
		
		String resultStr3 = (var1 > var2) ? "var1�� ũ��" : ((var1 < var2) ? "var2�� ũ��" : "var1�� var2�� ����");
		System.out.println(resultStr3);
		
	}

}
