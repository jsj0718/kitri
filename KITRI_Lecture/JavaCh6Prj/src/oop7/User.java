package oop7;

public class User {
	/*
	 * 1. final - ��� ���� (����, �޼ҵ�, Ŭ����)
	 * 		    - ������ ���� �������� ���ϰ� ����� �ϳ��� ���� ��� ����
	 * 		      (����, ���� ����)
	 * 		    - ��� �������� ������ �빮�ڷ� ���´�. ���� �ܾ� ��ĥ ���� _�� ��ģ��.
	 * 
	 * ��) final int NUMBER = 10;
	 * 	  final String START = "START";
	 * 
	 * 	  fianl String END;
	 * 
	 * 	  ������() {
	 * 		END = "END";
	 * 	  }
	 * 
	 * 
	 * 2. static - ��üȭ�� �������� �ʰ� ����� �� �ְ� ����� ��ɾ�
	 * 			 - ����, �޼ҵ忡 ��� ����
	 * 
	 * ��) class A {
	 * 	  		static int number = 10;
	 * 	   }
	 * 
	 *    class B {
	 *           main() {
	 *           	A a = new A();	// x
	 *           	sysout(a.number);	// x
	 *           	
	 *           	sysout(A.number);	// o (��, �޸� ������ ũ�� ������ �����ϸ� ��� X)
	 *           }
	 *    }
	 *    
	 * 3. static final - ������ �������� ��� ������ ���
	 * 				   - ���� ����� static final�� ���
	 * 
	 * ��) static final int NUMBER_TEN = 10;
	 *    static final String GAME_START = "START";
	 *    static final String GAME_END = "END";
	 *    
	 *    static final int NUMBER_TEN;
	 *    static {
	 *    		NUMBER_TEN = �ʱⰪ;
	 *    }
	 */
	
	final int NUMBER = 10;	// ���
	final String START = "START";
	final String END = "END";
	
	void method() {
		System.out.println(NUMBER);
		System.out.println(START);
		System.out.println(END);
	}
	
	// static
	static int a = 10;
	static String str = "���ڰ�";
	
	// static final (��ġ �ٲ��� ��� X)
	final static int NUMBER_TEN = 10;
	static final String GAME_START = "START";
	
	
}
