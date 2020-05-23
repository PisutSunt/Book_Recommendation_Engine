import java.io.Serializable;
import java.util.ArrayList;
import javafx.util.Pair;

public class Cart implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 7695178204958042383L;
    private static ArrayList<Pair<Book, Integer>> selectedBooks = new ArrayList<Pair<Book, Integer>>();
    private float totalPrice = 0;

    public float getTotalPrice()
    {
        float totalPrice = 0;
        for (Pair<Book,Integer> pair : selectedBooks)
        {
            for (int i = 0; i < pair.getValue(); i++)
            {
                totalPrice += pair.getKey().getPrice();
            }
        }
        return totalPrice;
    }

    public ArrayList<Pair<Book, Integer>> getSelectedBooks()
    {
        return selectedBooks;
    }

    private void calculateTotalPrice()
    {
        float totalPrice = 0;
        for (Pair<Book,Integer> item : selectedBooks) 
        {
            totalPrice += item.getKey().getPrice() * item.getValue();
        }
        this.totalPrice = totalPrice;
    }

    public boolean addBookToCart(Book book)
    {
    	int remaining = book.getRemaining();
		System.out.print("\nEnter number of book to buy(remaining " + remaining + ")");
		int bookCount = IOUtils.checkInputMenu(0, remaining);
    	
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
}