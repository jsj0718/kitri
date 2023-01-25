
public class VarCasting {

	public static void main(String[] args) {
		/*
		 * ����ȯ (Casting)
		 *  - �⺻ Ÿ�� ����ȯ
		 *   1) String + all type : String���� ��ȯ��
		 *   2) ������ ����� int Ÿ������ ��ȯ
		 *     - 1 + 1 -> int
		 *     - byte b = 12;
		 *     - short s = 20;
		 *     - b + s = 32 (int ��)
		 *   
		 *   - �⺻ Ÿ�� ����ȯ ���
		 *   long longVal = 1000;
		 *   int intVal = (int) d; // (��ȯ�� Ÿ��) ������
		 *   ---------------
		 *   int intVal1 = 1000;
		 *   long longVal1 = (long)intVal1; // ���� Ÿ�Կ��� ū Ÿ������ �� ���� ĳ���� ���� ����
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
