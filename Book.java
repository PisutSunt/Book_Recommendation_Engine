
public class Book
{
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

    public Book(String title, String author, String genre, int lengthInPages, float price, int totalBought, String bookAbstract, int remaining, String ISBN)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.lengthInPages = lengthInPages;
        this.price = price;
        this.totalBought = totalBought;
        this.bookAbstract = bookAbstract;
        this.remaining = remaining;
        this.ISBN = ISBN;
        keywords = title + " " + author + " " + genre + " " +
                    bookAbstract + " " + ISBN;
    }

    public Book(String title, String author, String genre, int lengthInPages, float price, String bookAbstract, int remaining, String ISBN)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.lengthInPages = lengthInPages;
        this.price = price;
        this.bookAbstract = bookAbstract;
        this.remaining = remaining;
        this.ISBN = ISBN;
        keywords = title + " " + author + " " + genre + " " +
                    bookAbstract + " " + ISBN;
    }
}