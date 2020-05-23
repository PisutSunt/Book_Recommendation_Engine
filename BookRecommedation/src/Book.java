import java.io.Serializable;
/**
 * The class Book represents the book in the Book Store.
 * Book includes title, author, genre, lengthInPages, price, all data about the book
 * 
 * Book class implements Serializable for converting its
 * state to a byte stream. So, the byte stream can be reverted back
 * into a copy of the it.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class Book implements Comparable<Book>, Serializable
{
	/** auto generated serialVersionUID is used for verifying the class in serialization and deserialization */
	private static final long serialVersionUID = 1705450082691153155L;

	/** title of the book in String */
	private String title;

	/** author or writer of the book in String */
	private String author;

	/** genre or category of the book in String */
	private String genre;

	/** page length of the book in integer type */
	private int lengthInPages;

	/** keywords that combinded from every data of book and split with underscore "_" */
	private String keywords;

	/** price of the book in float type */
	private float price;

	/** number of copy of book that be bought, start with 0 copy */
	private int totalBought = 0;

	/** abstract of the book in String */
	private String bookAbstract;

	/** number of remaining books in the store in integer type */
	private int remaining;

	/** ISBN number of the book in String */
	private String ISBN;

	/**
	 * constructor of Book would accept title, author, genre, lengthInPages, price, bookAbstract, remaining
	 * and ISBN for creating a new Book
	 * @param title title of the book in String
	 * @param author author or writer of the book in String
	 * @param genre genre or category of the book in String
	 * @param lengthInPages page length of the book in integer type
	 * @param price price of the book in float type
	 * @param bookAbstract abstract of the book in String
	 * @param remaining number of remaining books in the store in integer type
	 * @param ISBN ISBN number of the book in String
	 */
	public Book(String title, String author, String genre, int lengthInPages, float price, String bookAbstract,
			int remaining, String ISBN)
	{
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.lengthInPages = lengthInPages;
		this.price = price;
		this.bookAbstract = bookAbstract;
		this.remaining = remaining;
		this.ISBN = ISBN;
		keywords = title + "_" + author + "_" + genre + "_" + ISBN;
	}

	/**
	 * title getter method
	 * @return title of the book in String
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * author getter method
	 * @return author or writer of the book in String
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * genre getter method
	 * @return genre or category of the book in String
	 */
	public String getGenre()
	{
		return genre;
	}

	/**
	 * lengthInPages getter method
	 * @return page length of the book in integer type
	 */
	public int getLengthInPages()
	{
		return lengthInPages;
	}

	/**
	 * keywords getter method
	 * @return keywords that combinded from every data of book and split with underscore "_"
	 */
	public String getKeywords()
	{
		return keywords;
	}

	/**
	 * price getter method
	 * @return price of the book in float type
	 */
	public float getPrice()
	{
		return price;
	}

	/**
	 * totalBought getter method
	 * @return number of copy of book that be bought, start with 0 copy
	 */
	public int getTotalBought()
	{
		return totalBought;
	}

	/**
	 * bookAbstract getter method
	 * @return abstract of the book in String
	 */
	public String getAbtract()
	{
		return bookAbstract;
	}

	/**
	 * remaining getter method
	 * @return number of remaining books in the store in integer type
	 */
	public int getRemaining()
	{
		return remaining;
	}

	/**
	 * ISBN getter method
	 * @return ISBN number of the book in String
	 */
	public String getISBN()
	{
		return ISBN;
	}

	/**
	 * decrease remaining number of book with the number of bought book
	 * @param reducingNo number of bought book
	 */
	public void decreaseRemaining(int reducingNo)
	{
		remaining -= reducingNo;
	}

	/**
	 * use for compare between book with totalBought comparison by desending
	 * @param comingBook refer to another book
	 * @return differnce of remaining number from both book
	 */
	@Override
	public int compareTo(Book comingBook)
	{
		return comingBook.getTotalBought() - this.totalBought;
	}
}