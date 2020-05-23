import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 * The class BillCollection represents folder for keeping Bill.
 * BillCollection class could getBillCollection and addBill.
 * 
 * BillCollection class implements Serializable for converting its
 * state to a byte stream. So, the byte stream can be reverted back
 * into a copy of the it.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class BillCollection implements Serializable
{
    /** auto generated serialVersionUID is used for verifying the class in serialization and deserialization */
    private static final long serialVersionUID = -8532049033326057555L;

    /** billCollection is array of Bill */
    private ArrayList<Bill> billCollection = new ArrayList<Bill>();

    /**
     * billCollection getter method
     * @return ArrayList of Bill
     */
    public ArrayList<Bill> getBillCollection()
    {
        return billCollection;
    }

    /**
     * add Bill to the member ArrayList
     * @param bill new creating bill
     * @return true if adding is success
     */
    public boolean addBill(Bill bill)
    {
        try
        {
            this.billCollection.add(bill);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

}