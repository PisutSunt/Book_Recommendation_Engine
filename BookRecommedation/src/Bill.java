import java.util.ArrayList;
import java.util.Date;
import javafx.util.Pair;

public class Bill
{
    private int billNo;
    private Profile buyer;
    private ArrayList<Pair<Book, Integer>> boughtBooks;
    private String receiver;
    private String shippingAddress;
    private float totalPrice;
    private Date date;
    static private int billCounter = 0;

    public Bill(Cart cart, Profile buyer,String receiver, String shippingAddress)
    {
        billNo = billCounter;
        this.buyer = buyer;
        boughtBooks = cart.getSelectedBooks();
        this.receiver = receiver;
        this.shippingAddress = shippingAddress;
        totalPrice = cart.getTotalPrice();
        date = new Date();
        billCounter++;
    }

    public Bill(int billNo, Profile buyer, ArrayList<Pair<Book, Integer>> boughtBooks, String receiver, 
            String shippAddress, float totalPrice, long milliseconds)
    {
        this.billNo = billNo;
        this.buyer = buyer;
        this.boughtBooks = boughtBooks;
        this.receiver = receiver;
        this.shippingAddress = shippAddress;
        this.totalPrice = totalPrice;
        date = new Date(milliseconds);
        billCounter++;
    }
}