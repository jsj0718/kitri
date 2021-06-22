package inheritance;

public class AnimalMain {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		cat.sound();
		cat.eat();
		cat.walk();
		cat.run();
		
		dog.sound();
		dog.eat();
		dog.walk();
		dog.run();
	}

}
