package spring.di;

public class A implements I {
	private I i;

	public void setI(I i) {
		this.i = i;
	}
	
	public A() {
	}
	
	public A(I i) {
		this.i = i;
	}

	@Override
	public void print() {
		System.out.println("print A 출력");
		
//		I i = new B();
		i.print();
	}
	
//	public void printA() {
//		System.out.println("print A 출력");
//	}
}
