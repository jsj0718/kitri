package madang;

import java.util.ArrayList;

public class BookFunction {
	public static void main(String[] args) {
		// DB 선언
		ArrayList<Book> list = new ArrayList<>();
		
		// insert 실행
		insert(list, 1, "축구의 역사", "굿스포츠", 7000);
		insert(list, 2, "축구를 아는 여자", "굿스포츠", 13000);
		insert(list, 3, "자바의 정석", "이지퍼블리싱", 20000);

		// update 실행
		update(list, 1, "농구의 역사");

		// delete 실행
		delete(list, 2);
		
		// select 실행
//		select(list);
		
		insert(list, 2, "오라클", "한빛", 25000);
		select(list);
	}
	
	static void insert(ArrayList<Book> list, int bookID, String bookName, String publisher, int price) {
		Book book = new Book();
		
		book.setBookID(bookID);
		book.setBookName(bookName);
		book.setPublisher(publisher);
		book.setPrice(price);
		
		list.add(book);
	}
	
	static void select(ArrayList<Book> list, int bookID) {
		for (Book book : list) {
			if (book.getBookID() == bookID) {
				System.out.printf("책 번호 : %d, 책 이름 : %s, 출판사 : %s, 가격 : %d\n", book.getBookID(), book.getBookName(), book.getPublisher(), book.getPrice());			
			}			
		}
	}
	
	static void select(ArrayList<Book> list) {
		for (Book book : list) {
			System.out.printf("책 번호 : %d, 책 이름 : %s, 출판사 : %s, 가격 : %d\n", book.getBookID(), book.getBookName(), book.getPublisher(), book.getPrice());		
			
		}
	}
	
	static void update(ArrayList<Book> list, int bookID, String bookName) {
		for (Book book : list) {
			if (book.getBookID() == bookID) {
				book.setBookName(bookName);
			}			
		}
	}
	
	static void delete(ArrayList<Book> list, int bookID) {
//		예외 발생(java.util.concurrentmodificationexception)
//		for (Book book : list) {
//			if (book.getBookID() == bookID) {
//				list.remove(list.indexOf(book));
//			}			
//		}
		
		int size = list.size(); 
		for(int i = 0; i < size; i++) { 
			Book book = list.get(i); 
			// 요소를 안전하게 삭제하기 위해 size와 i를 --해줌
			if(book.getBookID() == bookID) { 
				list.remove(book); 
				size--; 
				i--; 
			}
		}
		
		// sort 진행
	}
}
