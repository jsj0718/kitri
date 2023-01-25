package madang;

import java.util.ArrayList;

public class BookFunction2 {
	// book Ŭ���� Ÿ���� ArrayList ���� (�������� ����)
	ArrayList<Book> list = new ArrayList<>();

	void insertBook(Book book) {
		list.add(book);
	}
	
	void selectBook() {
		System.out.println("BOOKID \t\t BOOKNAME \t\t PUBLISHER \t\t PRICE");
		for (Book book : list) {
			System.out.printf("å ��ȣ : %d \t å �̸� : %s \t ���ǻ� : %s \t\t ���� : %d\n", book.getBookID(), book.getBookName(), book.getPublisher(), book.getPrice());
		}
	}
	
	void selectBook(int bookID) {
		System.out.println("BOOKID \t\t BOOKNAME \t\t PUBLISHER \t\t PRICE");
		for (Book book : list) {
			if (book.getBookID() == bookID) {
				System.out.printf("å ��ȣ : %d \t å �̸� : %s \t ���ǻ� : %s \t\t ���� : %d\n", book.getBookID(), book.getBookName(), book.getPublisher(), book.getPrice());				
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
			// ArrayList�� get()���� ��Ҹ� ������
			Book book = list.get(i); 
			// ��Ҹ� �����ϰ� �����ϱ� ���� size�� i�� --����
			if(book.getBookID() == bookID) { 
				list.remove(book); 
				size--; 
				i--;
			}
		}
	}
}
