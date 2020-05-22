
public class TestClass
{
	public static void main(String[] args) 
	{
		ProfileCollection.initialize();
		Book b1 = new Book("aaaaaaaaaaaaaaa", "Authoraaaaaaaaaaaa", "Education", 3, 10, "bookAbstract", 9, "1");
		Book b2 = new Book("bbbbbbbbbbbbbbb", "Buthorrrrrrrrrrrrr", "Sci-Fi", 4, 20, "bookAbstract", 8, "2");
		Book b3 = new Book("ccccccccccccccc", "Cuthorrrrrrrrrrrrr", "Comics", 4, 20, "bookAbstract", 8, "3");
		BookCollection.addBook(b1);
		BookCollection.addBook(b2);
		BookCollection.addBook(b3);
//		System.out.println(BookCollection.getBookCollection());
//		ArrayList<Pair<Book, Integer>> itemList = new ArrayList<>();
//		Pair<Book, Integer> item = new Pair<Book,Integer>(b2, 1);
//		Pair<Book, Integer> item2 = new Pair<Book,Integer>(b1, 1);
//		itemList.add(item);
//		BookCollection.addUserBuyBook(p3, itemList);
//		BillManager.createBill(p3, itemList, "receiver", "shippingAddress", 30);
		// System.out.println(p3.getUserBillCollection().getBillCollection());
//		itemList.add(item2);
//		BookCollection.addUserBuyBook(p2, itemList);
//		BillManager.createBill(p2, itemList, "receiver", "shippingAddress", 40);
//		System.out.println(BookCollection.recommendByContent(p1));
		// System.out.println(BookCollection.recommendByCommunity(p3));
		 try
		 {
		 	IOUtils.WriteObjectToFile("bookCollection", BookCollection.getBookCollection());
		 }
		 catch (Exception exception)
		 {
		 	exception.printStackTrace();
		 }
		 Index.showIndex();
	}
}
