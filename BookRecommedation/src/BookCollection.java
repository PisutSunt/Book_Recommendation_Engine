import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;
import javafx.util.Pair;

public class BookCollection
{
    public static Hashtable<String, Book> bookCollection = new Hashtable<String, Book>();
    private static Hashtable<String, ArrayList<Profile>> userListBuyBook = new Hashtable<String, ArrayList<Profile>>();

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
        System.out.println();
        ArrayList<Pair<Book, Integer>> latestItems = user.getUserBillCollection().getBillCollection()
                    .get(user.getUserBillCollection().getBillCollection().size() - 1).getBoughtBooks();
        for (Pair<Book, Integer> item : latestItems)
        {
            Book tempBook = item.getKey();
            communitySet.addAll(userListBuyBook.get(tempBook.getKeywords()));
        }
        for (Profile tempUser : communitySet) 
        {
            for (Pair<Book, Integer> item : tempUser.getUserBillCollection().getBillCollection()
                .get(tempUser.getUserBillCollection().getBillCollection().size() - 1).getBoughtBooks()) 
            {
                if (!userListBuyBook.get(item.getKey().getKeywords()).contains(user))
                    recommendBookSet.add(item.getKey());
            }
        }
        recommendBookList.addAll(recommendBookSet);
        Collections.sort(recommendBookList);
        return recommendBookList;
    }

    public static void addUserBuyBook(Profile user, ArrayList<Pair<Book, Integer>> itemList)
    {
        for (Pair<Book, Integer> item : itemList) 
        {
            Book book = item.getKey();
            if (userListBuyBook.keySet().contains(book.getKeywords()))
            {
                if (!userListBuyBook.get(book.getKeywords()).contains(user))
                {
                    ArrayList<Profile> tempList = userListBuyBook.get(book.getKeywords());
                    tempList.add(user);
                    userListBuyBook.replace(book.getKeywords(), tempList);
                }
            }
            else
            {
                ArrayList<Profile> newUserList = new ArrayList<Profile>();
                newUserList.add(user);
                userListBuyBook.put(book.getKeywords(), newUserList);
            }
        }
    }

	public static List<String> searchBooks(String keywords)
	{
		List<String> list = bookCollection.keySet().stream().filter(s -> s.contains(keywords))
				.collect(Collectors.toList());
		if(list.isEmpty())
			return null;
		else
			return list;
    }
    
    public static boolean isBookEnough(ArrayList<Pair<Book,Integer>> items)
    {
        for (Pair<Book,Integer> item : items) 
        {
            if (item.getKey().getRemaining() < item.getValue())
                return false;
        }
        return true;
    }

    public static void decreaseRemainingBooks(ArrayList<Pair<Book,Integer>> items)
    {
        for (Pair<Book,Integer> item : items) 
        {
            Book tempBook = bookCollection.get(item.getKey().getKeywords());
            tempBook.decreaseRemaining(item.getValue());
            bookCollection.replace(tempBook.getKeywords(), bookCollection.get(item.getKey()
                .getKeywords()), tempBook);
        }
    }
}
