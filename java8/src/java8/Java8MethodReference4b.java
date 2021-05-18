package java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Java8MethodReference4b {

    public static void main(String[] args) {

        List<BigDecimal> list = Arrays.asList(
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(2.99),
                BigDecimal.valueOf(8.99));

        // lambda
        // List<Invoice1> Invoice1s = fakeInvoice1(list, (price) -> new Invoice1(price));

        // method reference
        List<Invoice1> Invoice1s = fakeInvoice1(list, Invoice1::new);

        Invoice1s.forEach(System.out::println);
    }

    static List<Invoice1> fakeInvoice1(List<BigDecimal> list, Function<BigDecimal, Invoice1> func) {
        List<Invoice1> result = new ArrayList<>();

        for (BigDecimal amount : list) {
            result.add(func.apply(amount));
        }
        return result;
    }
    

}
class Invoice1 {

    String no;
    BigDecimal unitPrice;
    Integer qty;

    public Invoice1(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

	@Override
	public String toString() {
		return "Invoice1 [no=" + no + ", unitPrice=" + unitPrice + ", qty=" + qty + "]";
	}
}


