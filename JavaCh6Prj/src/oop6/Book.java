package oop6;

public class Book {
	/*
	 * bookid		number
	 * bookname		varchar2
	 * publisher	varchar2
	 * price		number
	 */
	
	int bookid;
	String bookname;
	String publisher;
	int price;
	
	void select() {
		System.out.println(bookid + "/t" 
							+ bookname + "\t" 
							+ publisher + "\t"
							+ price);
	}
	
	void insert(int bookid, String bookname, String publisher, int price) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}
	
	void update(int bookid, String bookname) {
		if (this.bookid == bookid) {
			this.bookname = bookname;
		}
	}
	
	void delete(int bookid) {
		if (this.bookid == bookid) {
			this.bookid = 0;
			this.bookname = null;
			this.price = 0;
			this.publisher = null;
		}
	}
	
}