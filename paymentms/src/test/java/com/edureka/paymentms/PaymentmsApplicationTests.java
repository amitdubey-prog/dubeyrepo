package com.edureka.paymentms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@SpringBootTest
class PaymentmsApplicationTests {

	@Test
	public void test_GenericsObject() {
		List<Object> lQ = new ArrayList<>();
		lQ.add("a");
		lQ.add(2);

		lQ.forEach(s-> System.out.println(s));
	}

	@Test
	public void test_Generics() {
		List<? extends Object> lQ = new ArrayList<>();
//		lQ.add("a");
//		lQ.add(2);
	}

	@Test
	public void test_GenericsQuestionMArk() {
		List<String> strings = Arrays.asList("a", "b");
//		checkQ(strings);
		checkQOnly(strings);
		List<Object> objects = Arrays.asList(new Object(), new Object());
		checkObject(objects);
		checkQ(objects);
	}

	private void checkQOnly(List<?> list) {
		list.forEach(System.out::println);
	}

	private void checkQ(List<? extends Object> list) {
		list.forEach(System.out::println);
	}

	private void checkObject(List<Object> list) {
		list.forEach(System.out::println);
	}

	@Test
	void nullTest() {
		Abc abc = new Abc();
		abc.method(null);
	}

	@Test
	void contextLoads() {
		System.out.println(someMethodMain());
	}

	private int someMethodMain() {
		try {
			someMethod(); //may throw exception
			System.out.println("1");
			return 1;
		} catch(Exception e) {
			System.out.println("2");
			return 2;
		} finally {
			System.out.println("3");
			return 3;
		}
	}

	private void someMethod() throws Exception {
		throw new Exception("abc");
	}

	public class Abc {
		public void method(Object a) {
			System.out.println("Object");
		}

		public void method(String a) {
			System.out.println("String");
		}

//		public void method(Integer a) {}

	}

}
