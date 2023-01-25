package madang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MadangMain {
	public static void main(String[] args) throws IOException {
		BookFunction2 bf = new BookFunction2();
//		Book book = new Book();
//		book.setBookID(1);
//		book.setBookName("�౸�� ����");
//		book.setPublisher("�½�����");
//		book.setPrice(15000);
//		bf.insertBook(book);
//
//		Book book1 = new Book();
//		book1.setBookID(2);
//		book1.setBookName("�ڹ��� ����");
//		book1.setPublisher("�Ѻ�");
//		book1.setPrice(20000);
//		bf.insertBook(book1);
//
//		Book book2 = new Book();
//		book2.setBookID(3);
//		book2.setBookName("���� ����");
//		book2.setPublisher("�½�����");
//		book2.setPrice(13000);
//		bf.insertBook(book2);
//
//		Book book3 = new Book(4, "�౸�� ����", "����", 23000);
//		bf.insertBook(book3);
//		
//		bf.updateBook(4, "������ ����");
//		bf.deleteBook(2);
//		bf.updateBook(3, "����Ŭ�� ����");
//		bf.selectBook();
		
		BufferedReader br = null;
			
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\madang\\data")));			
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(", ");
				
				Book book = new Book();
				book.setBookID(Integer.parseInt(arr[0]));
				book.setBookName(arr[1]);
				book.setPublisher(arr[2]);
				book.setPrice(Integer.parseInt(arr[3]));
				
				bf.insertBook(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) br.close();
		}
		
		bf.selectBook();
	}
}
