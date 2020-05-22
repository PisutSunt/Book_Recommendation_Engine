import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.util.Pair;

public class Cart implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 7695178204958042383L;
    private ArrayList<Pair<Book, Integer>> selectedBooks;
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

    public boolean addBookToCart(Pair<Book, Integer> item)
    {
        try
        {
            selectedBooks.add(item);
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

    public void purchase()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t*** Fill delivery information ***");
        System.out.print("Receiver name: ");
        String receiver = scanner.nextLine();
        System.out.print("Address: ");
        String shippingAddress = scanner.nextLine();
        // BillManager.createBill(buyer, selectedBooks, receiver, shippingAddress, totalPrice);
    }
}