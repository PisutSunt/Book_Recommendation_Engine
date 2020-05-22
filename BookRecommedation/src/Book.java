import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1705450082691153155L;
	private String title;
	private String author;
	private String genre;
	private int lengthInPages;
	private String keywords;
	private float price;
	private int totalBought = 0;
	private String bookAbstract;
	private int remaining;
	private String ISBN;

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

	public String getTitle()
	{
		return title;
	}

	public String getAuthor()
	{
		return author;
	}

	public String getGenre()
	{
		return genre;
	}

	public int getLengthInPages()
	{
		return lengthInPages;
	}

	public String getKeywords()
	{
		return keywords;
	}

	public float getPrice()
	{
		return price;
	}

	public int getTotalBought()
	{
		return totalBought;
	}

	public String getAbtract()
	{
		return bookAbstract;
	}

	public int getRemaining()
	{
		return remaining;
	}

	public String getISBN()
	{
		return ISBN;
	}

	public void decreaseRemaining(int reducingNo)
	{
		remaining -= reducingNo;
	}

	@Override
	public int compareTo(Book comingBook)
	{
		return comingBook.getTotalBought() - this.totalBought;
	}
}