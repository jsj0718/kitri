package abs;

public class IndiUser extends User  {
	String registNumber;
	@Override
	void userInfo() {
		System.out.println("�̸� : " + name);
		System.out.println("�̸��� : " + email);
		System.out.println("�ּ� : " + address);
		System.out.println("�ֹι�ȣ1 : " + registNumber);
	}
	public void setRegisterNumber(String string) {
	}

}
