import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class BookCollection
{
    public static Hashtable<String, Book> bookCollection = new Hashtable<String, Book>();
    private static Hashtable<Book, ArrayList<Profile>> userListBuyBook = new Hashtable<Book, ArrayList<Profile>>();

    public static Book getBook(String keyword)
    {
        return bookCollection.get(keyword);
    }

    public static void addBook(Book book)
    {
        bookCollection.put(book.getKeywords(), book);
    }

    public static Hashtable<String, Book> getBookCollection()
    {
        return bookCollection;
    }

    public static ArrayList<Book> recommendByContent(Profile user)
    {
        String[] userGenre = user.getGenre();
        ArrayList<Book> recommendBooks = new ArrayList<Book>();
        for (String genre : userGenre) 
        {
            Set<String> keyBookSet = bookCollection.keySet()
                .stream()
                .filter(s -> s.contains("_" + genre + "_"))
                .collect(Collectors.toSet());
            for (String key : keyBookSet) 
                recommendBooks.add(bookCollection.get(key));
        }
        Collections.sort(recommendBooks);
        return recommendBooks;
    }

    public static ArrayList<Book> recommendByCommunity(Profile user)
    {
        ArrayList<Book> recommendBookList = new ArrayList<Book>();
        Set<Book> recommendBookSet = new LinkedHashSet<Book>();
        Set<Profile> communitySet = new LinkedHashSet<Profile>();
        ArrayList<Pair<Book, Integer>> latestItems = user.getBill().get(user.getBill().size() - 1).getBoughtBooks();
        for (Pair<Book, Integer> item : latestItems)
        {
            Book tempBook = item.getKey();
            communitySet.addAll(userListBuyBook.get(tempBook));
        }
        for (Profile tempUser : communitySet) 
        {
            for (Pair<Book, Integer> item : tempUser.getBill().get(tempUser.getBill().size() - 1).getBoughtBooks()) 
            {
                recommendBookSet.add(item.getKey());
            }
        }
        recommendBookList.addAll(recommendBookSet);
        Collections.sort(recommendBookList);
        return recommendBookList;
    }
}