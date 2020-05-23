import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javafx.util.Pair;
/**
 * The class Bill represents proof document of payment in the Book Store.
 * Bill includes billNo, buyer, boughtBooks, receiver, shippingAddress, totalPrice and orderDate.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class Bill implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -9197236779513368141L;

    /** unique key of bill in the integer type */
    private int billNo;

    /** owner of Bill in the Profile type */
    private String buyer;

    /** buying item list, each item represents by pair of Book object and quantity of book(s) */
    private ArrayList<Pair<Book, Integer>> boughtBooks;

    /** String name of receiver for book delivery */
    private String receiver;

    /** String address of receiver for book delivery */
    private String shippingAddress;

    /** float of the net cost of each Bill */
    private float totalPrice;

    /** Date of payment */
    private long orderDate;

    /**
     * Constructor would accept billNo, buyer, bought, receiver, shippingAddress and totalPrice
     * to set members directly and set orderDate by call Date constructor.
     * @param billNo unique key of bill in the integer type
     * @param buyer owner of Bill in the Profile type
     * @param boughtBooks buying item list, each item represents by pair of Book object and quantity of book(s)
     * @param receiver String name of receiver for book delivery
     * @param shippingAddress String address of receiver for book delivery
     * @param totalPrice float of the net cost of each Bill
     */
    public Bill(int billNo, String buyer, ArrayList<Pair<Book, Integer>> boughtBooks, String receiver, 
            String shippingAddress, float totalPrice)
    {
        this.billNo = billNo;
        this.buyer = buyer;
        this.boughtBooks = boughtBooks;
        this.receiver = receiver;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        orderDate = new Date().getTime();
    }

    /**
     * billNo getter method
     * @return billNo in integer type
     */
    public int getBillNo()
    {
        return billNo;
    }
    
    /**
     * buyer getter method
     * @return buyer in Profile type
     */
    public String getBuyer()
    {
    	return buyer;
    }
    
    /**
     * boughtBooks getter method
     * @return list of pair of Book and number of bought books
     */
    public ArrayList<Pair<Book, Integer>> getBoughtBooks()
    {
    	return boughtBooks;
    }
    
    /**
     * receiver name getter method
     * @return receiver name in String 
     */
    public String getReceiver()
    {
    	return receiver;
    }
    
    /**
     * shipping address getter method
     * @return receiver address in String
     */
    public String getShippingAddress()
    {
    	return shippingAddress;
    }
    
    /**
     * total price or net cost getter method
     * @return price in float type
     */
    public float getTotalPrice()
    {
    	return totalPrice;
    }
    
    /**
     * date of payment getter method
     * @return date in Date type
     */
    public Date getOrderDate()
    {
    	return new Date(orderDate);
    }
}