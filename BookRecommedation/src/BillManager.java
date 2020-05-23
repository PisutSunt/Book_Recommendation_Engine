import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;
/**
 * The class BillManager is singleton and represents handler Bill
 * and BillCollection. BillManager class could findBillCollection
 * and createBill.
 * 
 * BillManager class implements Serializable for converting its
 * state to a byte stream. So, the byte stream can be reverted back
 * into a copy of the it.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class BillManager 
{
    /** auto generated serialVersionUID is used for verifying the class in serialization and deserialization */
    // private static final long serialVersionUID = 6517082982239447106L;

    /** Hashtable allBillCollection store BillCollection by the Profile as key. */
    private static HashMap<String, ArrayList<Bill>> allBillCollection = new HashMap<>();

    /** billCounter is increased by 1 for running number of billNo. billNo begin at 1 */
    private static int billCounter = 1;

    /**
     * findBillCollection is used for get BillCollection by use the key user: Profile
     * @param user Profile type is used for key of hashtable
     * @return BillCollection of user
     */
    public static ArrayList<Bill> findBillCollection(Profile user)
    {
        // return allBillCollection.get(user.getUserName());
        return allBillCollection.get(user.getUserName());
    }

    /**
     * createBill method would create the new instance of Bill and store in allBillCollection
     * @param buyer user in Profile type
     * @param boughtBooks items of buying books and quantity of them
     * @param receiver receiver name in String
     * @param shippingAddress receiver address in String
     * @param totalPrice net cost of books in float type
     */
    public static void createBill(Profile buyer, ArrayList<Pair<Book, Integer>> boughtBooks, 
                            String receiver, String shippingAddress, float totalPrice)
    {
        billCounter++;
        Bill newBill = new Bill(billCounter, buyer.getUserName(), boughtBooks, receiver, shippingAddress, totalPrice);
        if (allBillCollection.containsKey(buyer.getUserName()))
        {
            ArrayList<Bill> billCollection = allBillCollection.get(buyer.getUserName());
            billCollection.add(newBill);
            allBillCollection.replace(buyer.getUserName(), billCollection);
        }
        else
        {
            ArrayList<Bill> billCollection = new ArrayList<>();
            billCollection.add(newBill);
            allBillCollection.put(buyer.getUserName(), billCollection);
        }
        updateFile();
    }
    
    public static void initialize()
    {
    	try
		{
            allBillCollection = (HashMap<String, ArrayList<Bill>>)IOUtils.ReadObjectFromFile("..\\billCollection");
		}
		catch (Exception exception)
		{
            exception.printStackTrace();
            
		}
    }
    
    public static void updateFile()
    {
    	IOUtils.WriteObjectToFile("..\\billCollection", allBillCollection);
    }
}