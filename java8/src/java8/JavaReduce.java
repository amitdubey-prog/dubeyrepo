/**
 * 
 */
package java8;

/**
 *A simple map and reduce example to sum BigDecimal from a list of Invoice4s.
 *
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class JavaReduce {

    public static void main(String[] args) {

        List<Invoice4> Invoice4s = Arrays.asList(
                new Invoice4("A01", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
                new Invoice4("A02", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
                new Invoice4("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(2))
        );

        BigDecimal sum = Invoice4s.stream()
                .map(x -> x.getQty().multiply(x.getPrice()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);      // reduce

        System.out.println(sum);    // 49.955
        System.out.println(sum.setScale(2, RoundingMode.HALF_UP));  // 49.96

    }

}
class Invoice4 {

    String invoiceNo;
    public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public Invoice4(String invoiceNo, BigDecimal price, BigDecimal qty) {
		super();
		this.invoiceNo = invoiceNo;
		this.price = price;
		this.qty = qty;
	}
	BigDecimal price;
    BigDecimal qty;

    // getters, stters n constructor
}

