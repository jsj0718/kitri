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
//		book.setBookName("축구의 역사");
//		book.setPublisher("굿스포츠");
//		book.setPrice(15000);
//		bf.insertBook(book);
//
//		Book book1 = new Book();
//		book1.setBookID(2);
//		book1.setBookName("자바의 정석");
//		book1.setPublisher("한빛");
//		book1.setPrice(20000);
//		bf.insertBook(book1);
//
//		Book book2 = new Book();
//		book2.setBookID(3);
//		book2.setBookName("농구의 역사");
//		book2.setPublisher("굿스포츠");
//		book2.setPrice(13000);
//		bf.insertBook(book2);
//
//		Book book3 = new Book(4, "축구의 이해", "대한", 23000);
//		bf.insertBook(book3);
//		
//		bf.updateBook(4, "골프의 이해");
//		bf.deleteBook(2);
//		bf.updateBook(3, "오라클의 정석");
//		bf.selectBook();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\madang\\data")));
		
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
		
		bf.selectBook();
	}
}
