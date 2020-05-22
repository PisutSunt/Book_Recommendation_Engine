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
        System.out.println();
        ArrayList<Pair<Book, Integer>> latestItems = user.getUserBillCollection().getBillCollection()
                    .get(user.getUserBillCollection().getBillCollection().size() - 1).getBoughtBooks();
        for (Pair<Book, Integer> item : latestItems)
        {
            Book tempBook = item.getKey();
            communitySet.addAll(userListBuyBook.get(tempBook));
        }
        for (Profile tempUser : communitySet) 
        {
            for (Pair<Book, Integer> item : tempUser.getUserBillCollection().getBillCollection()
                .get(tempUser.getUserBillCollection().getBillCollection().size() - 1).getBoughtBooks()) 
            {
                if (!userListBuyBook.get(item.getKey()).contains(user))
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
            if (userListBuyBook.keySet().contains(book))
            {
                if (!userListBuyBook.get(book).contains(user))
                {
                    ArrayList<Profile> tempList = userListBuyBook.get(book);
                    tempList.add(user);
                    userListBuyBook.replace(book, tempList);
                }
            }
            else
            {
                ArrayList<Profile> newUserList = new ArrayList<Profile>();
                newUserList.add(user);
                userListBuyBook.put(book, newUserList);
            }
        }
    }

	public static List<String> searchBooks(String keywords)
	{
		List<String> list = bookCollection.keySet().stream().filter(s -> s.contains(keywords))
				.collect(Collectors.toList());
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			System.out.println("\t   Title\t\t\tAuthor\t\t\tGenre\t\t\tISBN");
			int index = 1;
			for (String key : list)
			{
				Book book = bookCollection.get(key);
				System.out.printf("\t%d. %-28s %-23s %-23s %s\n", index, book.getTitle(), book.getAuthor(), book.getGenre(), book.getISBN());
				index++;
			}
			
			return list;
		}
		
	}
	
	
}
