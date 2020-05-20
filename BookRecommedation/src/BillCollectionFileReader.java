import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class BillCollectionFileReader 
{
    public Object ReadObjectFromFile() 
    {
        String filepath = ".\\backup\\billCollection";
        try
        {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            System.out.println("Bill collection has been read from the file");
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