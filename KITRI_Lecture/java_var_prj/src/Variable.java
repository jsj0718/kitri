
public class Variable {

	public static void main(String[] args) {
		/*
		 * ���� : ���� �����ϱ� ���� ����
		 * 
		 * ���� �ۼ� ��� : 
		 * 1. ����Ÿ�� ������ = �ʱ�ȭ��;
		 * 2. ����Ÿ�� ������;
		 *    ������ = �ʱ�ȭ��;
		 *    
		 *    ����) 1. int a = 0;
		 *         2. int a;
		 *            a = 0;
		 * 
		 * ���� Ÿ�� ����
		 * 1. �⺻ Ÿ�� (8��)
		 * 		- �� : boolean -> true, false
		 * 		- ���� : char -> 'a' // ���� �ϳ� ��
		 *                      ''  // �� �� �ȵ�
		 * 		- ���� : byte, short, int, long -> ������ (int �켱)
		 *                1     1     1    1L
		 * 		- �Ǽ� : float, double -> �Ǽ��� (double �켱)
		 *               1.1f   1.1
		 *               
		 * 		* ctrl + d : ���� ����
		 * 
		 * 2. ���� Ÿ��
		 * 		- �⺻ Ÿ���� ������ ������ (Ŭ���� Ÿ��)
		 * 		- String
		 * 		* String ��� ��� : String str = "���ڿ�"; // ��, ���ڿ�, null ����
		 * 						   String str1 = "";
		 * 	                       String str2 = null;
		 */
		
		boolean flag = true;
		System.out.println("boolean �� : " + flag);
		
		char c = 'a';	// ���� �ϳ� ��
		System.out.println("char �� : " + c);		
		
		int i = 123;
		System.out.println("char�� int�� �հ� = " + c + i);
		
		float f = 12.59f;
		System.out.println("float �� : " + f);
		System.out.println("--------------------------");
		String str1 = "���ڿ��Դϴ�.";
		String str2 = "";
		String str3 = null;
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		
		str1 = "null���� ����";
		str2 = "����� ����";
		System.out.println(str1 + " " +str2);
		
		/*
		 * VariableEx
		 * ���� �Ұ�
		 * 	- �̸�
		 *  - ����
		 *  - Ű
		 *  - �б�
		 *  - �ּ�
		 *  - �ڵ���
		 *  - ��ȣ 
		 */
	}

}
