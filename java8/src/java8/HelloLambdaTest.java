package java8;

import java.util.function.Consumer;

public class HelloLambdaTest {
	public static void main(String[] args) {
		
/*		//Anonymous Class
		HelloLambda helloLambda=new HelloLambda() {
			
			@Override
			public void sayHello() {
				System.out.println("Hello World");
			}
		};
		
		helloLambda.sayHello();
*/
		Consumer<String> consumer2 = System.out::println;
		consumer2.accept("Hello Amit");
		
		
	}
}