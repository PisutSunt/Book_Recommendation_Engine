import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import javafx.util.Pair;
/**
 * 
 */
public class BillManager implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 6517082982239447106L;
    private static Hashtable<Profile, BillCollection> allBillCollection = new Hashtable<Profile, BillCollection>();
    private static int billCounter = 1;

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
//        updateFile();
    }
    
    public static void initialize()
    {
    	try
		{
    		allBillCollection = (Hashtable<Profile, BillCollection>)IOUtils.ReadObjectFromFile("billCollection");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }
    
    public static void updateFile()
    {
    	IOUtils.WriteObjectToFile("billCollection", (Hashtable<Profile, BillCollection>)allBillCollection);
    }
    
    
}