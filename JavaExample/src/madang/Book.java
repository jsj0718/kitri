package madang;

public class Book {
	private int bookID;
	private String bookName;
	private String publisher;
	private int price;
	
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Book() {
	}
	
	Book(int bookID, String bookName, String publisher, int price) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.publisher = publisher;
		this.price = price;
	}
	
	// Generate toString()을 통해 자동 생성 가능
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", publisher=" + publisher + ", price=" + price
				+ "]";
	}
	
	
}
