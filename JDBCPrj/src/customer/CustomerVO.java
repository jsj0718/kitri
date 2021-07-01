package customer;

public class CustomerVO {
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
	
	@Override
	public String toString() {
		return "CustomerVO [custID=" + custID + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
	
}
