import java.util.ArrayList;

import javafx.util.Pair;

public class TestClass
{
	public static void main(String[] args) 
	{
		// WelcomePage welcome = new WelcomePage();
		String[] e = {"s", "ee", "qe"};
		Profile p = new Profile("userName", "email", "password", e);
		Book b = new Book("title", "author", "genre", 1, 30, "bookAbstract", 9, "ISBN");
		ArrayList<Pair<Book, Integer>> a = new ArrayList<Pair<Book, Integer>>();
		Bill bill = new Bill(1, p, a, "receiver", "shippAddress", 2, 88888908978789L);
		ProfileCollecionFileWriter.WriteObjectToFile(p);
		BookCollectionFileWriter.WriteObjectToFile(b);
		BillCollectionFileWriter.WriteObjectToFile(bill);
	}
}
