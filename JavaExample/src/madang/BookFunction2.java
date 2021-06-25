package madang;

import java.util.ArrayList;

public class BookFunction2 {
	// book 클래스 타입의 ArrayList 생성 (전역변수 생성)
	ArrayList<Book> list = new ArrayList<>();

	void insertBook(Book book) {
		list.add(book);
	}
	
	void selectBook() {
		System.out.println("BOOKID \t\t BOOKNAME \t\t PUBLISHER \t\t PRICE");
		for (Book book : list) {
			System.out.printf("책 번호 : %d \t 책 이름 : %s \t 출판사 : %s \t\t 가격 : %d\n", book.getBookID(), book.getBookName(), book.getPublisher(), book.getPrice());
		}
	}
	
	void selectBook(int bookID) {
		System.out.println("BOOKID \t\t BOOKNAME \t\t PUBLISHER \t\t PRICE");
		for (Book book : list) {
			if (book.getBookID() == bookID) {
				System.out.printf("책 번호 : %d \t 책 이름 : %s \t 출판사 : %s \t\t 가격 : %d\n", book.getBookID(), book.getBookName(), book.getPublisher(), book.getPrice());				
			}
		}
	}
	
	void updateBook(int bookID, String bookName) {
		for (Book book : list) {
			if (book.getBookID() == bookID) {
				book.setBookName(bookName);
			}
		}
	}
	
	void deleteBook(int bookID) {
		int size = list.size();
		for(int i = 0; i < size; i++) { 
			// ArrayList의 get()으로 요소를 가져옴
			Book book = list.get(i); 
			// 요소를 안전하게 삭제하기 위해 size와 i를 --해줌
			if(book.getBookID() == bookID) { 
				list.remove(book); 
				size--; 
				i--;
			}
		}
	}
}
