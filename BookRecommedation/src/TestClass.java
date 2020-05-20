import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestClass
{
	public static void main(String[] args) 
	{
		// WelcomePage welcome = new WelcomePage();
		String[] e = {"s", "ee", "qe"};
		Profile p = new Profile("userName", "email", "password", e);
		try {
 
            FileOutputStream fileOut = new FileOutputStream("backup/ex.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(p);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
        }
	}
}
