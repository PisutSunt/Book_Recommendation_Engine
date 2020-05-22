import java.util.Hashtable;

public class TestClass
{
	public static void main(String[] args) 
	{
		String[] genre = {"a", "d"};
		Profile p1 = new Profile("x", "a@mail.com", "password", genre);
		Profile p2 = new Profile("y", "b@mail.com", "password", genre);
		try{
			ProfileCollection.initialize();
			ProfileCollection.showAllProfile();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
