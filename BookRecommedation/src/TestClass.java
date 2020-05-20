import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestClass
{
	public static void main(String[] args) 
	{
		// WelcomePage welcome = new WelcomePage();
		String[] e = {"s", "ee", "qe"};
		Profile p = new Profile("userName", "email", "password", e);
		ProfileCollecionFileWriter.WriteObjectToFile(p);

		try {
            FileInputStream fileIn = new FileInputStream(".\\backup\\obj");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
			objectIn.close();
			System.out.println(obj.getClass());
			System.out.println(((Profile)obj).getUserName());
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
