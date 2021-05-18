package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class demo {

	public static void main(String[] args) {
    
		System.out.println("Hello Amit");
	
		List<String> list = Arrays.asList("node", "java", "python", "ruby");
		list.forEach(new Consumer<String>() {       // anonymous class
		    @Override
		    public void accept(String str) {
		        System.out.println(str);
		    }
		});

		System.out.println("-----Using Lambda-------");
		list.forEach(str ->System.out.println(str));
		System.out.println("-----method reference-------");
		list.forEach(System.out::println);
		System.out.println("-----Using Map -------");
		Map<String, Integer> map = new HashMap<>();
	      map.put("A", 10);
	      map.put("B", 20);
	      map.put("C", 30);
	      map.put(null, 40);
	      map.put("E", null);
	      map.put("F", 60);
	      map.forEach((k,v) ->System.out.println("Key : " + k + ", Value : " + v));
	    		  
	    		  
	  	System.out.println("-----Using Lambda-------");
	  	
	 // lambda
	  	
	  	map.forEach(
	            (k, v) -> {
	                // yes, we can put logic here
	                if (k != null){
	                    System.out.println("Key : " + k + ", Value : " + v);
	                }
	            }
	        );
		
	}
	
}
	
