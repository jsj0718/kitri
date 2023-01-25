package oop5;

public class User {
	String id;
	String name;
	String address;
	int age;
	
	// User(){} X
	User(){	// 기본 생성자를 적어줌
		this("user", "사용자", "경기도", 11);
		System.out.println("기본 생성자 User() 호출");
	} 
		
	
	// 생성자를 이용하여 초기화 진행
	User(String id, String name, String address, int age) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	
}
