import java.io.Serializable;
import java.util.ArrayList;
import javafx.util.Pair;

public class Cart implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 7695178204958042383L;
    private ArrayList<Pair<Book, Integer>> selectedBooks;

    public float getTotalPrice()
    {
        float totalPrice = 0;
        for (Pair<Book,Integer> pair : selectedBooks)
        {
            for (int i = 0; i < pair.getValue(); i++)
            {
                totalPrice += pair.getKey().getPrice();
            }
        }
        return totalPrice;
    }

    public ArrayList<Pair<Book, Integer>> getSelectedBooks()
    {
        return selectedBooks;
    }
}