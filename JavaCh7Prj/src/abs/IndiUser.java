package abs;

public class IndiUser extends User  {
	String registNumber;
	@Override
	void userInfo() {
		System.out.println("이름 : " + name);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + address);
		System.out.println("주민번호1 : " + registNumber);
	}
	public void setRegisterNumber(String string) {
	}

}
