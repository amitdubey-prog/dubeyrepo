package java8;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Java8MethodReference4a {

    public static void main(String[] args) {

        // lambda
        Supplier<Map> obj1 = () -> new HashMap();   // default HashMap() constructor
        Map map1 = obj1.get();
        System.out.println(map1);
        // method reference
        Supplier<Map> obj2 = HashMap::new;
        Map map2 = obj2.get();
        System.out.println(map2);
        // lambda
        Supplier<Invoice> obj3 = () -> new Invoice(); // default Invoice() constructor
        Invoice invoice1 = obj3.get();
        System.out.println(invoice1);
        // method reference
        Supplier<Invoice> obj4 = Invoice::new;
        Invoice invoice2 = obj4.get();
        System.out.println(invoice2);

    }

}

class Invoice {

    String no;
    BigDecimal unitPrice;
    Integer qty;

    public Invoice() {
    }
    
    //... generated by IDE
}