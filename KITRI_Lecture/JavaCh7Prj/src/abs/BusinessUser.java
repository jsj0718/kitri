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
		System.out.println("이름 : " + name);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + address);
		System.out.println("사업자 번호 : " + businessNumber);
	}

}
