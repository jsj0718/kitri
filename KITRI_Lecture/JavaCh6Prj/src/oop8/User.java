package oop8;

public class User {
	/*
	 * 
	 * getter, setter
	 * 	- Ŭ���� ���� ���������� �����ְ� ĸ��ȭ�Ͽ� ����� �� �ְ� ���ִ� ����
	 * 
	 * private : �ٸ� Ŭ�������� ��üȭ�� ���� ��� �Ұ���
	 * ����)
	 * private String name;
	 * private String age;
	 * private String address;
	 * private String email;
	 * 
	 *	// getter
	 *	public String getName() {
	 *		return name;
	 *	}
	 *
	 *	// setter
	 *	public void setName(String name) {
	 *		this.name = name;
	 *	}
	 *
	 *	MainClass {
	 *		main() {
	 *			User user = new User();
	 *			sysout(user.getName());
	 *
	 *			user.setName("ȫ�浿");
	 *		}
	 *	}
	 */
	
	private String name;
	private int age;
	private String address;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
