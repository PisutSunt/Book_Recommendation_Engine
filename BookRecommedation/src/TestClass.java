public class TestClass
{
	public static void main(String[] args) 
	{
<<<<<<< HEAD
//		WelcomePage welcome = new WelcomePage();
		ProfileCollection.initialize();
//		ProfileCollection.showAllProfile();
		Index.showIndex();
		
=======
		Book b1 = new Book("a", "A", "fun", 3, 10, "bookAbstract", 9, "1");
		Book b2 = new Book("b", "B", "sad", 4, 20, "bookAbstract", 8, "2");
		BookCollection.addBook(b1);
		BookCollection.addBook(b2);
		try
		{
			IOUtils.WriteObjectToFile(".\\backup\\bookCollection", BookCollection.getBookCollection());
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
>>>>>>> 71eb79db1eda07a60c1ac8e868c5e01787b1428f
	}
}
