import java.util.ArrayList;
import java.util.Hashtable;

import javafx.util.Pair;

public class BillManager 
{
    private static Hashtable<Profile, BillCollection> allBillCollection = new Hashtable<Profile, BillCollection>();
    private static int billCounter = 0;

    // public static Bill searchBill(int billNo)
    // {
    //     for (BillCollection billCollection : allBillCollection) 
    //     {
    //         for (Bill bill : billCollection.getBillCollection()) 
    //         {
    //             if (bill.getBillNo() == billNo)
    //                 return bill;
    //         }
    //     }
    //     return null;
    // }

    public static void createBill(Profile buyer, ArrayList<Pair<Book, Integer>> boughtBooks, 
                            String receiver, String shippingAddress, float totalPrice)
    {
        Bill newBill = new Bill(billCounter, buyer, boughtBooks, receiver, shippingAddress, totalPrice);
        buyer.updateBillCollection(newBill);
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
        billCounter++;
    }
}