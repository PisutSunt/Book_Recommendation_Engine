import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader
{
    private BufferedReader reader = null;

    public boolean openFile(String filename)
    {
        boolean bOk = true;
        try
        {
            if (reader != null)
                reader.close();
        }
        catch (IOException ioException)
        {
            reader = null;
        }
        try
        {
            reader = new BufferedReader(new FileReader(filename));
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("Fail to open the file.");
            bOk = false;
            reader = null;
        }
        return bOk;
    }

    public String getNextLine()
    {
        String lineRead = null;
        try
        {
            if (reader != null)
            {
                lineRead = reader.readLine();
                if (lineRead == null)
                {
                    reader.close();
                }
            }
        }
        catch (IOException ioException)
        {
            lineRead = null;
        }
        return lineRead;
    }

    public void closeFile()
    {
        try
        {
            reader.close();
        }
        catch (IOException ioException)
        {
            System.out.println("Fail to close file");
        }
    }
}