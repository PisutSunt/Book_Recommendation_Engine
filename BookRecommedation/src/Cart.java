import java.io.Serializable;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 * The class Cart represents cart or basket for containig books to buy
 * 
 * Cart class implements Serializable for converting its state to a byte stream.
 * So, the byte stream can be reverted back into a copy of the it.
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class Cart implements Serializable
{
	/**
	 * auto generated serialVersionUID is used for verifying the class in
	 * serialization and deserialization
	 */
	private static final long serialVersionUID = 7695178204958042383L;

	/** refers to books and quantity that the user has selected */
	private static ArrayList<Pair<Book, Integer>> selectedBooks = new ArrayList<Pair<Book, Integer>>();

	/** the current net price of book */
	private float totalPrice = 0;

	/**
	 * calculate the total price
	 */
	private void calculateTotalPrice()
	{
		float totalPrice = 0;
		for (Pair<Book, Integer> item : selectedBooks)
		{
			totalPrice += item.getKey().getPrice() * item.getValue();
		}
		this.totalPrice = totalPrice;
	}

	/**
	 * add a book to the cart
	 * 
	 * @param book      refers to book that may be bought
	 * @param bookCount refers to number of book that user want to buy
	 * @return true - if add book successfully
	 */
	public boolean addBookToCart(Book book, int bookCount)
	{
		try
		{
			selectedBooks.add(new Pair<>(book, bookCount));
			calculateTotalPrice();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * remove the book out of the cart
	 * 
	 * @param item a book with quantity that be selected
	 * @return true - if remove it successfully
	 */
	public boolean removeBookFromCart(Pair<Book, Integer> item)
	{
		try
		{
			if (!selectedBooks.remove(item))
				return false;
			calculateTotalPrice();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * print all of book and its quantity in the cart
	 */
	public void showAllBooksInCart()
	{
		if (!selectedBooks.isEmpty())
		{
			System.out.println("------------- Your cart -------------");
			int index = 0;
			for (Pair<Book, Integer> pair : selectedBooks)
			{
				index++;
				System.out.println("\t" + index + ". " + pair.getKey().getTitle() + "   " + pair.getValue() + " pcs.");
			}
			System.out.println("\n\tTotal price: " + totalPrice + " baht");
		}
		else
		{
			System.out.println("*** Your cart is empty! ***");
		}
	}

	/**
	 * purchasing or buying all books in the cart
	 * 
	 * @param buyer user in Profile type
	 * @return true - if purchase them successfully
	 */
	public boolean purchase(Profile buyer)
	{
		if (BookCollection.isBookEnough(selectedBooks) && PaypalAdapter.pay())
		{
			BookCollection.decreaseRemainingBooks(selectedBooks);
			System.out.println("*** Fill delivery information ***");
			System.out.print("Receiver name> ");
			String receiver = IOUtils.getString();
			System.out.print("Address> ");
			String shippingAddress = IOUtils.getString();
			BillManager.createBill(buyer, selectedBooks, receiver, shippingAddress, totalPrice);
			BookCollection.addUserBuyBook(buyer, selectedBooks);
			selectedBooks.clear();
			return true;
		}
		return false;
	}

	/**
	 * totalPrice getter method
	 * 
	 * @return the current net price of book
	 */
	public float getTotalPrice()
	{
		return totalPrice;
	}

	/**
	 * selectedBooks getter method
	 * 
	 * @return refers to books and quantity that the user has selected
	 */
	public ArrayList<Pair<Book, Integer>> getSelectedBooks()
	{
		return selectedBooks;
	}
}