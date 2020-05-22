import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class BookCollection
{
	public static Hashtable<String, Book> bookCollection = new Hashtable<String, Book>();

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