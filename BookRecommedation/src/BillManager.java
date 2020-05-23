import java.util.ArrayList;
import java.util.Hashtable;
import javafx.util.Pair;
/**
 * The class BillManager is singleton and represents handler Bill
 * and BillCollection. BillManager class could findBillCollection
 * and createBill.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class BillManager 
{
    /** Hashtable allBillCollection store ArrayList of Bill by the String of user name as key. */
    private static Hashtable<String, ArrayList<Bill>> allBillCollection = new Hashtable<String, ArrayList<Bill>>();

    /** billCounter is increased by 1 for running number of billNo. billNo begin at 1 */
    private static int billCounter = 1;

    /**
     * findBillCollection is used for get BillCollection by use the key user: Profile
     * @param user Profile type to get user name using for key of hashtable
     * @return list of bill that own by the user
     */
    public static ArrayList<Bill> findBillCollection(Profile user)
    {
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
    
    /**
     * for starting the program, this method would be called to read bill information from file.
     */
    public static void initialize()
    {
    	try
		{
            allBillCollection = (Hashtable<String, ArrayList<Bill>>)IOUtils.ReadObjectFromFile("..\\billCollection");
		}
		catch (Exception exception)
		{
            exception.printStackTrace();
            
		}
    }
    
    /**
     * everytime the members have changed, this method would be called to update new data to file
     */
    private static void updateFile()
    {
    	IOUtils.WriteObjectToFile("..\\billCollection", allBillCollection);
    }
}