import java.util.ArrayList;
import java.util.Dictionary;

public class BookCollection
{
    public static Dictionary<String, Book> bookCollection;
    private ArrayList<Book> bookToShow;

    public static Book getBook(String keyword)
    {
        return bookCollection.get(keyword);
    }
}