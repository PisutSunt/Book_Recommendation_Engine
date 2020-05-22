import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Dictionary;
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

	public static boolean searchBooks(String keywords, String field)
	{
		Set<String> set = bookCollection.keySet().stream().filter(s -> s.contains(keywords))
				.collect(Collectors.toSet());

		if(set.isEmpty())
		{
			System.out.println("*** No item match your search ***");
			return false;
		}
		else
		{
			String methodName = field;
			Class[] parameterType = null;
			Book book = new Book("", "", "", 0, 0, "", 0, "");

			try
			{
				Method method = book.getClass().getMethod(methodName, parameterType);
				try
				{
					for (String key : set)
					{
						book = bookCollection.get(key);
						System.out.println(method.invoke(book));
					}
				}
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
				{
					e.printStackTrace();
				}
			}
			catch (NoSuchMethodException | SecurityException e)
			{
				e.printStackTrace();
			}
			
			return true;
		}
		
	}
}