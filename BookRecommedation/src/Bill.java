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
    private Date orderDate;

    public Bill(int billNo, Profile buyer, ArrayList<Pair<Book, Integer>> boughtBooks, String receiver, 
            String shippingAddress, float totalPrice)
    {
        this.billNo = billNo;
        this.buyer = buyer;
        this.boughtBooks = boughtBooks;
        this.receiver = receiver;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        orderDate = new Date();
    }

    public int getBillNo()
    {
        return billNo;
    }
    
    public Profile getBuyer()
    {
    	return buyer;
    }
    
    public ArrayList<Pair<Book, Integer>> getBoughtBooks()
    {
    	return boughtBooks;
    }
    
    public String getReceiver()
    {
    	return receiver;
    }
    
    public String getShippingAddress()
    {
    	return shippingAddress;
    }
    
    public float getTotalPrice()
    {
    	return totalPrice;
    }
    
    public Date getOrderDate()
    {
    	return orderDate;
    }
    
}