
public class Main
{
	public static void main(String[] args) 
	{
		ProfileCollection.initialize();
		BookCollection.initialize("bookCollection");
//		BillManager.initialize();
		
		/* This field for mockup data, It should be deleted after mockup complete */
		Book b1 = new Book("aaaaaaaaaaaaaaa", "Authoraaaaaaaaaaaa", "Education", 3, 10, "bookAbstract", 9, "1");
		Book b2 = new Book("bbbbbbbbbbbbbbb", "Buthorrrrrrrrrrrrr", "Sci-Fi", 4, 20, "bookAbstract", 8, "2");
		Book b3 = new Book("ccccccccccccccc", "Cuthorrrrrrrrrrrrr", "Comics", 4, 20, "bookAbstract", 8, "3");
		BookCollection.addBook(b1);
		BookCollection.addBook(b2);
		BookCollection.addBook(b3);
		// BookCollection.update();

		Index.showIndex();
	}
}
