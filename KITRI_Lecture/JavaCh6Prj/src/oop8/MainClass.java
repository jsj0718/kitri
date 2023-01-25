package oop8;

public class MainClass {
	public static void main(String[] args) {
		User user1 = new User();
		
		user1.setName("홍길동");
		user1.setAge(100);
		user1.setAddress("서울");
		user1.setEmail("daeman@gmail.com");
		
		System.out.println(user1.getName());
		System.out.println(user1.getAge());
		System.out.println(user1.getAddress());
		System.out.println(user1.getEmail());
		
		System.out.println("---------------");
		
		Book book1 = new Book();
		book1.setBookID(1);
		book1.setBookName("혼공자");
		book1.setPublisher("한빛미디어");
		book1.setPrice(20000);
		
		Book book2 = new Book();	
		book2.setBookID(2);
		book2.setBookName("혼공파");
		book2.setPublisher("한빛미디어");
		book2.setPrice(18000);

		Book book3 = new Book();	
		book3.setBookID(3);
		book3.setBookName("Do It");
		book3.setPublisher("이지퍼블리싱");
		book3.setPrice(15000);
		
		Book book4 = new Book();	
		book4.setBookID(4);
		book4.setBookName("축구의 이해");
		book4.setPublisher("대한출판사");
		book4.setPrice(36000);
		
		Book[] bookArray = new Book[4];
		bookArray[0] = book1;
		bookArray[1] = book2;
		bookArray[2] = book3;
		bookArray[3] = book4;
		for (Book b : bookArray) {
			System.out.print(b.getBookID() + "\t");
			System.out.print(b.getBookName() + "\t");
			System.out.print(b.getPublisher() + "\t");
			System.out.print(b.getPrice() + "\t\n");
			System.out.println("----------------------------------------");
		}
		
	}
}
