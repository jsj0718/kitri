package abs;

public class BusinessUser extends User {
	private String businessNumber;
	
	public String getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	@Override
	void userInfo() {
		System.out.println("�̸� : " + name);
		System.out.println("�̸��� : " + email);
		System.out.println("�ּ� : " + address);
		System.out.println("����� ��ȣ : " + businessNumber);
	}

}
