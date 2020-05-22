import java.util.ArrayList;
import java.util.Hashtable;

import javafx.util.Pair;

public class BillManager 
{
    private static Hashtable<Profile, BillCollection> allBillCollection = new Hashtable<Profile, BillCollection>();
    private static int billCounter = 0;

    public static BillCollection findBillCollection(Profile user)
    {
        return allBillCollection.get(user);
    }

    public static void createBill(Profile buyer, ArrayList<Pair<Book, Integer>> boughtBooks, 
                            String receiver, String shippingAddress, float totalPrice)
    {
    	billCounter++;
        Bill newBill = new Bill(billCounter, buyer, boughtBooks, receiver, shippingAddress, totalPrice);
        if (allBillCollection.contains(buyer))
        {
            BillCollection billCollection = allBillCollection.get(buyer);
            billCollection.addBill(newBill);
            allBillCollection.replace(buyer, billCollection);
        }
        else
        {
            BillCollection billCollection = new BillCollection();
            billCollection.addBill(newBill);
            allBillCollection.put(buyer, billCollection);
        }
       
    }
}