import java.io.Serializable;
import java.util.ArrayList;
/**
 * The class BillCollection represents folder for keeping Bill.
 * BillCollection class could getBillCollection and addBill.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class BillCollection implements Serializable
{
    
    private static final long serialVersionUID = -8532049033326057555L;
    private ArrayList<Bill> billCollection = new ArrayList<Bill>();

    public ArrayList<Bill> getBillCollection()
    {
        return billCollection;
    }

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