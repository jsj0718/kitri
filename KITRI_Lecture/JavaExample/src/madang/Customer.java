package madang;

public class Customer {
	private int custID;
	private String name;
	private String address;
	private String phone;
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Customer() {
		
	}
	
	public Customer(int custID, String name, String address, String phone) {
		this.custID = custID;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	
}
