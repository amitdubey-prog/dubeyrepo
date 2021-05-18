package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionExampleUsingjava8 {
	
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
	      list.add("A");
	      list.add("B");
	      list.add(null);
	      list.add("D");
	      list.add("E");

	      // normal loop
	      for (String l : list) {
	          System.out.println(l);
	      }
	      //lambda
	      System.out.println("------------lambda-------");
	      list.forEach(x -> System.out.println(x));
	      System.out.println("------------Methid Reference ------------");
	      // method reference
	      list.forEach(System.out::println);
	      
	      //filter null value
	      System.out.println("-----------Stream-------");
	      list.stream()
	              .filter(Objects::nonNull)
	              .forEach(System.out::println);

	      
		
	}

	
}
