package oop5;

public class User {
	String id;
	String name;
	String address;
	int age;
	
	// User(){} X
	User(){	// �⺻ �����ڸ� ������
		this("user", "�����", "��⵵", 11);
		System.out.println("�⺻ ������ User() ȣ��");
	} 
		
	
	// �����ڸ� �̿��Ͽ� �ʱ�ȭ ����
	User(String id, String name, String address, int age) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	
}
