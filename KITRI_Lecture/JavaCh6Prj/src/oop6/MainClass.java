package oop6;

public class MainClass {

	public static void main(String[] args) {
		Book book1 = new Book(1, "ȥ����", "�Ѻ��̵��", 20000);
		Book book2 = new Book(2, "����Ŭ", "�����ۺ���", 10000);
		Book book3 = new Book(3, "HTML/CSS", "�Ѻ��̵��", 25000);
		Book book4 = new Book(4, "Spring", "�����ۺ���", 30000);
		
		book1.select();
		book2.select();
		book3.select();
		book4.select();
		
		
	}

}
