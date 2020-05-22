import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class BookCollection
{
    public static Dictionary<String, Book> bookCollection = new Hashtable<String, Book>();
    private ArrayList<Book> bookToShow;

    public static Book getBook(String keyword)
    {
        return bookCollection.get(keyword);
    }

    public static void addBook(Book book)
    {
        bookCollection.put(book.getKeywords(), book);
    }

    public static Dictionary<String, Book> getBookCollection()
    {
        return bookCollection;
    }
}