package abs;

abstract public class User {
	/*
	 * �߻�Ŭ���� (�߻�޼ҵ常 �����ϸ� ��)
	 * - �߻�޼ҵ尡 ���Ե� Ŭ����
	 * - ���赵 ����
	 * - �Ϲݸ޼ҵ� ���� ����
	 * - �������� ���� ����
	 * - ���� ��� �Ұ��� (Interface�� ����)
	 * - ��üȭ �Ұ���
	 * 
	 * ��) abstract class Ŭ������ {}
	 * 
	 * �߻�޼ҵ�
	 * - �����(������)�� ����, ����θ� �ִ� �޼ҵ�
	 * 
	 * ��) abstract ��ȯŸ�� �޼ҵ��(�Ű�����);
	 * - {���๮}�� ����!
	 */
	
	protected String name;
	protected String email;
	protected String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	void login() {
		System.out.println("������ �α��� ����");
	}
	
	abstract void userInfo();
}
