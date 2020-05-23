/**
 * Used for launching the program
 * 
 * Created by Pisut Suntronkiti  ID: 60070501037
 *            Wuttithat Krongyot ID: 60070501084
 */
public class Main
{
	public static void main(String[] args) 
	{
		ProfileCollection.initialize();
		BillManager.initialize();
		BookCollection.initializeCollection();
		BookCollection.initializeUserList();
		
		/* This field for mockup data, It should be deleted after mockup complete */
		Book b1 = new Book("aaaaaaaaaaaaaaa", "Authoraaaaaaaaaaaa", "Education", 3, 10, "bookAbstract", 9, "1");
		Book b2 = new Book("bbbbbbbbbbbbbbb", "Buthorrrrrrrrrrrrr", "Sci-Fi", 4, 20, "bookAbstract", 8, "2");
		Book b3 = new Book("ccccccccccccccc", "Cuthorrrrrrrrrrrrr", "Comics", 4, 20, "bookAbstract", 8, "3");
		Book b4 = new Book("Ant-man", "Marvel", "Comics", 6, 20, "bookAbstract", 8, "4");
		Book b5 = new Book("Bat-Man", "DC", "Comics", 6, 20, "bookAbstract", 8, "5");
		BookCollection.addBook(b1);
		BookCollection.addBook(b2);
		BookCollection.addBook(b3);
		BookCollection.addBook(b4);
		BookCollection.addBook(b5);
		Index.showIndex();
	}
}
