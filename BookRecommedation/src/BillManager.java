import java.util.ArrayList;
import javafx.util.Pair;

public class BillManager 
{
    private static ArrayList<BillCollection> allBillCollection;
    private static int billCounter = 0;

    public static Bill searchBill(int billNo)
    {
        for (BillCollection billCollection : allBillCollection) 
        {
            for (Bill bill : billCollection.getBillCollection()) 
            {
                if (bill.getBillNo() == billNo)
                    return bill;
            }
        }
        return null;
    }

    public static void createBill(Profile buyer, ArrayList<Pair<Book, Integer>> boughtBooks, 
                            String receiver, String shippingAddress, float totalPrice)
    {
        Bill newBill = new Bill(billCounter, buyer, boughtBooks, receiver, shippingAddress, totalPrice);
    }
}