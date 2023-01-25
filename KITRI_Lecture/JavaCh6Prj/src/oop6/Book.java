package oop6;

public class Book {
	/*
	 * bookID		number
	 * bookName		varchar2
	 * publisher	varchar2
	 * price		number
	 */
	
	int bookID;
	String bookName;
	String publisher;
	int price;
	
	// 기본 생성자 생략
	// Book() {}
	
	Book(int bookID, String bookName, String publisher, int price) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.publisher = publisher;
		this.price = price;
	}
	
	void select() {
		System.out.println(bookID + "\t" 
							+ bookName + "\t" 
							+ publisher + "\t"
							+ price);
	}
	
	void insert(int bookID, String bookName, String publisher, int price) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.publisher = publisher;
		this.price = price;
	}
	
	void update(int bookID, String bookName) {
		if (this.bookID == bookID) {
			this.bookName = bookName;
		}
	}
	
	void delete(int bookID) {
		if (this.bookID == bookID) {
			this.bookID = 0;
			this.bookName = null;
			this.price = 0;
			this.publisher = null;
		}
	}
	
}