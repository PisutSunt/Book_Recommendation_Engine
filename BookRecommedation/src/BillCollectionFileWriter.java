import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BillCollectionFileWriter 
{
    static public void WriteObjectToFile(Object serObj) 
    {
        String filepath = ".\\backup\\billCollection";
        try
        {    
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("Bill collection was succesfully written to a file");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}