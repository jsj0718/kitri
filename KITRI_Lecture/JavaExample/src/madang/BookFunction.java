package madang;

import java.util.ArrayList;

public class BookFunction {
	public static void main(String[] args) {
		// DB ����
		ArrayList<Book> list = new ArrayList<>();
		
		// insert ����
		insert(list, 1, "�౸�� ����", "�½�����", 7000);
		insert(list, 2, "�౸�� �ƴ� ����", "�½�����", 13000);
		insert(list, 3, "�ڹ��� ����", "�����ۺ���", 20000);

		// update ����
		update(list, 1, "���� ����");

		// delete ����
		delete(list, 2);
		
		// select ����
//		select(list);
		
		insert(list, 2, "����Ŭ", "�Ѻ�", 25000);
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
				System.out.printf("å ��ȣ : %d, å �̸� : %s, ���ǻ� : %s, ���� : %d\n", book.getBookID(), book.getBookName(), book.getPublisher(), book.getPrice());			
			}			
		}
	}
	
	static void select(ArrayList<Book> list) {
		for (Book book : list) {
			System.out.printf("å ��ȣ : %d, å �̸� : %s, ���ǻ� : %s, ���� : %d\n", book.getBookID(), book.getBookName(), book.getPublisher(), book.getPrice());		
			
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
//		���� �߻�(java.util.concurrentmodificationexception)
//		for (Book book : list) {
//			if (book.getBookID() == bookID) {
//				list.remove(list.indexOf(book));
//			}			
//		}
		
		int size = list.size(); 
		for(int i = 0; i < size; i++) { 
			Book book = list.get(i); 
			// ��Ҹ� �����ϰ� �����ϱ� ���� size�� i�� --����
			if(book.getBookID() == bookID) { 
				list.remove(book); 
				size--; 
				i--; 
			}
		}
		
		// sort ����
	}
}
