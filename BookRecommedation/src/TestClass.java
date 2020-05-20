import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestClass
{
	public static void main(String[] args) 
	{
<<<<<<< HEAD
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
=======
//		WelcomePage welcome = new WelcomePage();
		Index index = new Index();
		
>>>>>>> 5ea38498676ad1aa02e1f9aa2318550cb69022c9
	}
}
