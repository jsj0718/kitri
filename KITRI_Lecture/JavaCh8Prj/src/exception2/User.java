package exception2;

public class User {

	static Account myAccount = new Account();
	public static void main(String[] args) {
		/*
		 * 1. ī�带 ATM�� �ֱ�
		 * 2. �����ư
		 * 3. �ݾ��Է�
		 * 4. ��й�ȣ �Է�
		 * 	(yes) 4-1. 5������ �Ѿ
		 * 	 (no) 4-2. "��й�ȣ�� �߸� �ԷµǾ����ϴ�." ���
		 * 
		 * 	5. ���¿� ���� �ִ��� Ȯ�� 
		 * 	(yes) 5-1-1. ���¿��� ����ݾ� ����
		 *        5-1-2. ���� ��������⿡�� �ޱ�	// ���� �߻� (ATM�� ���� ����)
		 * 	 (no) 5-2-1. "���� �����ϴ�." ���
		 * 6. ī�� �����ޱ�
		 */
		
		int money = 1000;
		try {
			System.out.println("ī�带 ATM�⿡ �ֱ�");
			System.out.println("�����ư Ŭ��");
			System.out.println("�ݾ� �Է�");
			System.out.println("��й�ȣ �Է�");
			System.out.println("���¿��� ����ݾ� ����");
			User user = new User();
			user.withdraw(money);	// ���¿��� ����
			
			System.out.println("���� ��������⿡�� �ޱ�");
			int myMoney = user.getMoney(money);
			System.out.println("�� �� : " + myMoney);
		} catch(Exception e) {
			System.out.println("���� �߻�");
		myAccount.money = myAccount.money + money;
			System.out.println("�� ���� : "+myAccount.money);
		} finally {
			System.out.println("ī�� �����ޱ�");				
		}
		
	}
	
	public void withdraw(int money) {
		myAccount.money -= money;
		System.out.println("�� ����: " + myAccount.money);
	}
	
	int atmMoney = 10000;
	public int getMoney(int money) throws Exception {
		atmMoney -= money;
		if (atmMoney < 0) {
			throw new Exception();
		}
		System.out.println("ATM: " + atmMoney);
		return money;
	}
}
