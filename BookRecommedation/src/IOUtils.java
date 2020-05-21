import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOUtils
{
    public static Object ReadObjectFromFile(String filepath) 
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            System.out.println("Finish reading from the file: " + filepath);
            objectIn.close();
            return obj;
        } 
        catch (Exception exception) 
        {
            exception.printStackTrace();
            return null;
        }
    }

    public static void WriteObjectToFile(String filepath, Object targetObj) 
    {
        try
        {    
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(targetObj);
            objectOut.close();
            System.out.println("Finish writing file to a filepath: " + filepath);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}