/**
 * 
 */
package java8;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 *In this example, the BiFunction<Integer, Integer, Integer> which accepts and returns the 
 *same type, can be replaced with BinaryOperator<Integer>
 */
public class Java8BinaryOperator1 {

    public static void main(String[] args) {

        // BiFunction
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;

        Integer result = func.apply(2, 3);

        System.out.println(result); // 5

        // BinaryOperator
        BinaryOperator<Integer> func2 = (x1, x2) -> x1 + x2;

        Integer result2 = func.apply(2, 3);

        System.out.println(result2); // 5

    }

}

