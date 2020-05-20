import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class BookCollectionFileReader 
{
    public Object ReadObjectFromFile() 
    {
        String filepath = ".\\backup\\bookCollection";
        try
        {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            System.out.println("Book collection has been read from the file");
            objectIn.close();
            return obj;
        } 
        catch (Exception exception) 
        {
            exception.printStackTrace();
            return null;
        }
    }
}