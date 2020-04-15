import java.util.ArrayList;
import javafx.util.Pair;

public class Cart
{
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