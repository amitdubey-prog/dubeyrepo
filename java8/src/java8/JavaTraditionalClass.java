package java8;

public class JavaTraditionalClass implements Greetings {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello World " + name);

	}

public static void main(String[] args) {
		JavaTraditionalClass test = new JavaTraditionalClass();
		greet(test, "Tom");

	}

private static void greet(Greetings greetingsInstance, String name) {
		greetingsInstance.sayHello(name);
	}

}