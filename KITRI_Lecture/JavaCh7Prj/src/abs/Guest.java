package abs;

public class Guest extends User {
	private String nickName;
	
	@Override
	void userInfo() {
		System.out.println("�̸� : " + name);
		System.out.println("�̸��� : " + email);
		System.out.println("�ּ� : " + address);
		System.out.println("�г��� : " + nickName);
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
