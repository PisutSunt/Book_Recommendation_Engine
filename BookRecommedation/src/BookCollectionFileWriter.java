import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BookCollectionFileWriter 
{
    static public void WriteObjectToFile(Object serObj) 
    {
        String filepath = ".\\backup\\bookCollection";
        try
        {    
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("Book collection was succesfully written to a file");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}