import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;
import javafx.util.Pair;
/**
 * The class BookCollection is singletonand represents handler Book
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class BookCollection
{
    /** keep all of book with the book's keyword as the key of hash table */
    public static Hashtable<String, Book> bookCollection = new Hashtable<String, Book>();

    /** list of user who have bought the key book */
    private static Hashtable<String, ArrayList<Profile>> userListBuyBook = new Hashtable<String, ArrayList<Profile>>();

    /**
     * book getter method by its keyword
     * @param keyword keyword of the book
     * @return the target book
     */
	public static Book getBook(String keyword)
	{
		return bookCollection.get(keyword);
	}

    /**
     * add a new book to the collection
     * @param book a new book
     */
	public static void addBook(Book book)
	{
		bookCollection.put(book.getKeywords(), book);
		updateFileBookCollection();
	}

    /**
     * bookCollection getter method
     * @return book collection
     */
    public static Hashtable<String, Book> getBookCollection()
    {
        return bookCollection;
    }

    /**
     * recommedation process for user based on the content (genre/category)
     * @param user user in Profile type
     * @return a list of recommended books
     */
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

    /**
     * recommedation process for user based on user's community
     * @param user user in Profile type
     * @return a list of recommended books
     */
    public static ArrayList<Book> recommendByCommunity(Profile user)
    {
        if (BillManager.findBillCollection(user) != null)
        {
            ArrayList<Book> recommendBookList = new ArrayList<Book>();
            Set<Book> recommendBookSet = new LinkedHashSet<Book>();
            Set<Profile> communitySet = new LinkedHashSet<Profile>();
            System.out.println();
            ArrayList<Pair<Book, Integer>> latestItems = BillManager.findBillCollection(user)
                        .get(BillManager.findBillCollection(user).size() - 1).getBoughtBooks();
            for (Pair<Book, Integer> item : latestItems)
            {
                Book tempBook = item.getKey();
                communitySet.addAll(userListBuyBook.get(tempBook.getKeywords()));
            }
            for (Profile tempUser : communitySet) 
            {
                for (Pair<Book, Integer> item : BillManager.findBillCollection(tempUser)
                        .get(BillManager.findBillCollection(tempUser).size() - 1).getBoughtBooks())
                {
                    if (!userListBuyBook.get(item.getKey().getKeywords()).contains(user))
                        recommendBookSet.add(item.getKey());
                }
            }
            recommendBookList.addAll(recommendBookSet);
            Collections.sort(recommendBookList);
            return recommendBookList;
        }
        else
        {
        	return null;        	
        }
    }

    /**
     * add any user who bought a new book
     * @param user user in Profile type
     * @param itemList selected books by user
     */
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
        updateFileUserBookList();
    }

    /**
     * search for books by matching pattern of keywords
     * @param keywords keyword from user
     * @return a list of searched books
     */
	public static List<String> searchBooks(String keywords)
	{
		List<String> list = bookCollection.keySet().stream().filter(s -> s.contains(keywords))
				.collect(Collectors.toList());
		if(list.isEmpty())
			return null;
		else
			return list;
    }
    
    /**
     * check any book that exist enough for buying or not
     * @param items the selected books and quantity
     * @return  true - if all of interested books are effordable
     */
    public static boolean isBookEnough(ArrayList<Pair<Book,Integer>> items)
    {
        for (Pair<Book,Integer> item : items) 
        {
            if (item.getKey().getRemaining() < item.getValue())
                return false;
        }
        return true;
    }

    /**
     * decrese the remaining number of bought book
     * @param items items in bill or be bought
     */
    public static void decreaseRemainingBooks(ArrayList<Pair<Book,Integer>> items)
    {
        for (Pair<Book,Integer> item : items) 
        {
            Book tempBook = bookCollection.get(item.getKey().getKeywords());
            tempBook.decreaseRemaining(item.getValue());
            bookCollection.replace(tempBook.getKeywords(), bookCollection.get(item.getKey()
                .getKeywords()), tempBook);
        }
         updateFileBookCollection();
    }
    
    /**
     * for starting the program, this method would be called to read all books information from file.
     */
    public static void initializeCollection()
    {
    	try
		{
            bookCollection = (Hashtable<String, Book>)IOUtils.readObjectFromFile("bookCollection");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }
    
    /**
     * for starting the program, this method would be called to read all user who bought books information from file.
     */
    public static void initializeUserList()
    {
    	try
		{
            userListBuyBook = (Hashtable<String, ArrayList<Profile>>)IOUtils.readObjectFromFile("userListBuyBook");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }
    
    /**
     * everytime the bookCollection have changed, this method would be called to update new data to file
     */
    public static void updateFileBookCollection()
    {
    	IOUtils.writeObjectToFile("bookCollection", bookCollection);
    }
    
    /**
     * everytime the userListBuyBook have changed, this method would be called to update new data to file
     */
    public static void updateFileUserBookList()
    {
    	IOUtils.writeObjectToFile("userListBuyBook", userListBuyBook);    	
    }
}
