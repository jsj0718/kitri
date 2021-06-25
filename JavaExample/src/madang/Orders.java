package madang;

import java.util.Date;

public class Orders {
	private int orderID;
	private int custID;
	private int bookID;
	private int salePrice;
	private Date orderDate;
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Orders(int orderID, int custID, int bookID, int salePrice, Date orderDate) {
		this.orderID = orderID;
		this.custID = custID;
		this.bookID = bookID;
		this.salePrice = salePrice;
		this.orderDate = orderDate;
	}
	
	
	
}
