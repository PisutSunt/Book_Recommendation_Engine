import java.util.Hashtable;
import java.util.Set;
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

	public static int searchBooks(String keywords)
	{
		Set<String> set = bookCollection.keySet().stream().filter(s -> s.contains(keywords))
				.collect(Collectors.toSet());
		if(set.isEmpty())
		{
			return 0;
		}
		else
		{
			System.out.println("\t   Title\t\t\tAuthor\t\t\tGenre\t\t\tISBN");
			int index = 1;
			for (String key : set)
			{
				Book book = bookCollection.get(key);
				System.out.printf("\t%d. %-28s %-23s %-23s %s\n", index, book.getTitle(), book.getAuthor(), book.getGenre(), book.getISBN());
				index++;
			}
			
			
//			String methodName = field;
//			Class[] parameterType = null;
//			Book book = new Book("", "", "", 0, 0, "", 0, "");
//
//			try
//			{
//				Method method = book.getClass().getMethod(methodName, parameterType);
//				try
//				{
//					for (String key : set)
//					{
//						book = bookCollection.get(key);
//						System.out.println(method.invoke(book));
//					}
//				}
//				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			catch (NoSuchMethodException | SecurityException e)
//			{
//				e.printStackTrace();
//			}
//			
			return set.size();
		}
		
	}
}