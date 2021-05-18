package java8;

import java.util.Arrays;

/*
 * 
 * In Java 8, the Stream.reduce() combine elements of a stream and produces a single value
 */
public class StreamReduce {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);    // 55
		System.out.println(sum);
		int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);      // 55
		System.out.println(sum2);
		int sum3 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b);   // -55
		System.out.println(sum3);
		int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a * b);   // 0, initial is 0, 0 * whatever = 0
		System.out.println(sum4);
		int sum5 = Arrays.stream(numbers).reduce(0, (a, b) -> a / b);   // 0
		System.out.println(sum5);
		
		int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b);  // 10
		System.out.println(max);
		int max1 = Arrays.stream(numbers).reduce(0, Integer::max);            // 10
		System.out.println(max1);

		int min = Arrays.stream(numbers).reduce(0, (a, b) -> a < b ? a : b);  // 0
		System.out.println(min);
		int min1 = Arrays.stream(numbers).reduce(0, Integer::min);  
		System.out.println(min1);
		
		String[] strings = {"a", "b", "c", "d", "e"};

		  // |a|b|c|d|e , the initial | join is not what we want
		  String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);
		  System.out.println(reduce);

		  // a|b|c|d|e, filter the initial "" empty string
		  String reduce2 = Arrays.stream(strings).reduce("", (a, b) -> {
		      if (!"".equals(a)) {
		          return a + "|" + b;
		      } else {
		          return b;
		      }
		  });

		  System.out.println(reduce2);

		  // a|b|c|d|e , better uses the Java 8 String.join :)
		  String join = String.join("|", strings);
		  System.out.println(join);

	}

	
}
