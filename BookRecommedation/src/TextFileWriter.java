import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class TextFileWriter 
{
    protected BufferedWriter writer = null;

    public boolean creatFile(String filename)
    {
        boolean bOk = true;
        try
        {
            writer = new BufferedWriter(new FileWriter(filename));
        }
        catch (Exception exception)
        {
            System.out.println("Fail - " + exception);
            bOk = false;
            writer = null;
        }
        return bOk;
    }

    abstract protected void writeStructureGuide();

    public void closeFile()
    {
        try
        {
            writer.close();
        }
        catch (IOException ioException)
        {
            System.out.println("Fail to close file");
        }
    }
}